package com.chatter.controller;

import com.chatter.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class NotificationController {

    private final SimpMessageSendingOperations messagingTemplate;

    // Receives messages sent to /app/chat.sendMessage and broadcasts to /topic/messages
    @MessageMapping("/chat/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    // Adds user to WebSocket session (optional step for user tracking)
    @MessageMapping("/chat/addUser")
    @SendTo("/topic/users")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Store username in WebSocket session
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat/sendPrivateMessage")
    public void sendPrivateMessage(ChatMessage message) {
        // Send to specific user's queue
        messagingTemplate.convertAndSendToUser(
                message.getReceiver(), // username of recipient
                "/queue/messages",
                message
        );

        // Notify sender that it was delivered
        messagingTemplate.convertAndSendToUser(
                message.getSender(), "/queue/receipts",
                "Message delivered to " + message.getReceiver()
        );
    }
}

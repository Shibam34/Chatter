package com.chatter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Outgoing messages will be sent to clients subscribed to this broker
        config.enableSimpleBroker("/topic");
        // Prefix for client-sent messages (handled in controllers)
        config.setApplicationDestinationPrefixes("/api/chatter");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket endpoint for clients to connect
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS(); // Fallback for browsers without WebSocket support
    }
}

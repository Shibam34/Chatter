package com.chatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; // Thymeleaf will load chat.html
    }

    @GetMapping("/chat1")
    public String chat1() {
        return "chat1";
    }

    @GetMapping("/chat2")
    public String chat2() {
        return "chat2";
    }
}
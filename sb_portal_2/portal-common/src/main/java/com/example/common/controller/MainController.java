package com.example.common.controller;

import com.example.common.service.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final SessionService sessionService;
    public MainController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        // 세션에서 사용자 ID 가져오기
        String id = (String) httpSession.getAttribute("id");
        System.out.println("Logged in state: " + model.getAttribute("loggedIn"));
        if (id == null) {
            model.addAttribute("loggedIn", false);
        } else {
            // 외부 포탈의 Redis 데이터로 로그인 상태 확인
            boolean isLoggedIn = sessionService.isUserLoggedIn(id);
            model.addAttribute("loggedIn", isLoggedIn);
        }
        return "index"; // NAVBAR를 포함하는 뷰
    }
} 
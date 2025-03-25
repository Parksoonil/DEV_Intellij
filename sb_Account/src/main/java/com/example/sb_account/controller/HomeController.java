package com.example.sb_account.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Object loggedIn = session.getAttribute("loggedIn");
        model.addAttribute("isLoggedIn", loggedIn != null && ((Boolean) loggedIn));
        return "home";
    }
}

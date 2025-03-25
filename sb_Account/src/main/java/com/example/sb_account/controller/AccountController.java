package com.example.sb_account.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account/")
public class AccountController {
    @GetMapping("/list")
    public String list() {
        return "account/accountList";
    }
    @GetMapping("/edit")
    public String edit() {
        return "account/accountEdit";
    }
    @GetMapping("/register")
    public String create() {
        return "account/accountRegister";
    }
    @GetMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("loggedIn", true);
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

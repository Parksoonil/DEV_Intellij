package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "redirect:/tasks";
    }
    @GetMapping("/form2")
    public String form2() {
    	return "task/form2";
    }
    @GetMapping("/result")
    public String result(@RequestParam String str, Model model) {
    	System.out.println(str);
    	model.addAttribute("data", str);
    	return "task/result";
    }
} 
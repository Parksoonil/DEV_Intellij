package com.example.module1.controller;

import com.example.module1.service.SharedDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/module1")
public class Module1Controller {

    private final SharedDataService sharedDataService;
    public Module1Controller(SharedDataService sharedDataService) {this.sharedDataService = sharedDataService;}

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("data", sharedDataService.getData("shared_key"));
        model.addAttribute("moduleName", "Module 1");
        model.addAttribute("otherModuleUrl", "http://localhost:8082/module2/data/shared");
        return "module1/index";
    }
} 
package com.example.sb0320.controller;

import com.example.sb0320.dto.SampleDTO;
import com.example.sb0320.entity.MyUser;
import com.example.sb0320.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @Autowired
    private MyUserRepository myUserRepository;

    @GetMapping("/ex1")
    public String ex1(Model model) {
//        MyUser myUser = myUserRepository.findById(1L).get();
        MyUser myUser = myUserRepository.findByName("admin2");
        log.info(myUser.toString());
        model.addAttribute("name1", "홍길동");
        model.addAttribute("myUser", myUser);
        return "sample/ex1";
    }
    @GetMapping("/ex2")
    public String ex2(Model model) {
//        List<MyUser> myUser = myUserRepository.findAll();
        List<MyUser> myUser = myUserRepository.findMyUserByOrderByIdAsc();
        model.addAttribute("myUser", myUser);
        return "sample/ex2";
    }
}

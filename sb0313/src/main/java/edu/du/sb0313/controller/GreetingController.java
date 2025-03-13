package edu.du.sb0313.controller;

import edu.du.sb0313.dao.UserDao;
import edu.du.sb0313.dto.Users;
import edu.du.sb0313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class GreetingController {

    @Autowired
    private UserService userService;

    // 기본 URL로 접근 시 index.jsp로 이동
    @GetMapping("/")
    public String showGreetingForm() {
        return "index";  // index.jsp를 반환
    }

    // /greet 경로로 GET 요청이 오면 사용자가 입력한 이름을 받아서 greeting.jsp로 전달
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        Users user = userService.getUserByUsername(name);
        model.addAttribute("name", user.getId());  // 모델에 name 속성 추가
        model.addAttribute("pass", user.getPassword());
        return "index";  // greeting.jsp 뷰를 반환
    }
}


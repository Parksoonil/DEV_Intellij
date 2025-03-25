package com.example.account.controller;

import com.example.account.entity.Account;
import com.example.account.service.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
@RequestMapping("account/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "list";
    }
    @GetMapping("/edit")
    public String edit(Model model, HttpSession httpSession) {
        httpSession.setAttribute("id", "user01");
        String id = httpSession.getAttribute("id").toString();
        log.info("id:{}", id);
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "edit";
    }
    @PostMapping("/changepassword")
    public String changepassword(@RequestParam String password, @RequestParam String newpassword, HttpSession httpSession) {
        String id = httpSession.getAttribute("id").toString();
        log.info("id:{}", id);
        log.info(password);
        log.info(newpassword);
        boolean isPasswordValid = accountService.checkPassword(id, password);
        if (isPasswordValid) {
            accountService.updatePassword(id, newpassword);
            return "redirect:/account/list";
        } else {
            return "edit";
        }
    }
    @GetMapping("/register")
    public String create() {
        return "register";
    }
    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute Account account) {
        accountService.createAccount(account);
        return "redirect:/account/list";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        accountService.deleteById(id);
        return "redirect:/account/list";
    }






    @GetMapping("/loginForm")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String password,
                        RedisTemplate<String, Object> redisTemplate) {
        // 계정 찾기
        Account account = accountService.findById(id);

        // 계정이 존재하고 비밀번호가 올바른 경우 처리
        if (account != null && accountService.checkPassword(account.getId(), password)) {
            // Redis에 세션 저장 (30분 유효)
            String sessionKey = "session:" + id;
            redisTemplate.opsForValue().set(sessionKey, account, 30, TimeUnit.MINUTES);

            // 로그인 성공 시 메인 페이지로 리디렉션
            return "redirect:/account/";
        } else {
            // 로그인 실패 시 로그인 페이지로 리디렉션 및 에러 플래그 전달
            return "redirect:/account/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(@RequestParam String id,
                         RedisTemplate<String, Object> redisTemplate) {
        // Redis에서 세션 삭제
        String sessionKey = "session:" + id;
        redisTemplate.delete(sessionKey);

        // 로그아웃 후 로그인 페이지로 리디렉션
        return "redirect:/account/login";
    }

}

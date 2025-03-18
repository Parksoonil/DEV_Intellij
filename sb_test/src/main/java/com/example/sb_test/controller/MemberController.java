package com.example.sb_test.controller;

import com.example.sb_test.dto.MemberDTO;
import com.example.sb_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        List<MemberDTO> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        model.addAttribute("memberDTO", new MemberDTO());
        return "index";
    }

    @GetMapping("/{id}")
    public String getMemberById(@PathVariable Long id, Model model) {
        MemberDTO member = memberService.getMemberById(id);

        if (member != null) {
            model.addAttribute("member", member);
            return "list";
        } else {
            model.addAttribute("error", "멤버를 찾을 수 없습니다.");
            return "index";
        }
    }
    @PostMapping("/search")
    public String getMemberByName(@ModelAttribute MemberDTO memberDTO, Model model) {
        MemberDTO member = memberService.getMemberByName(memberDTO.getName());
        if (member != null) {
            model.addAttribute("member", member);
            return "list";
        } else {
            model.addAttribute("error", "멤버를 찾을 수 없습니다.");
            return "index";
        }

    }
}

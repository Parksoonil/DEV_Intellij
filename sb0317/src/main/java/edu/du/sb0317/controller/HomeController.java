package edu.du.sb0317.controller;

import edu.du.sb0317.spring.DuplicateMemberException;
import edu.du.sb0317.spring.MemberRegisterService;
import edu.du.sb0317.spring.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(
            MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String home() {
        return "success";
    }

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
            Model model) {
        if (!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
//		new RegisterRequestValidator().validate(regReq, errors);
        if (errors.hasErrors())
            return "register/step2";

        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
//			errors.rejectValue("email", "duplicate");
            errors.reject("notMatchingPassword");
            return "register/step2";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new RegisterRequestValidator());
    }
}

package com.example.fastlmsexample.member.controller;

import com.example.fastlmsexample.member.dto.MemberDto;
import com.example.fastlmsexample.member.entity.Member;
import com.example.fastlmsexample.member.model.MemberInput;
import com.example.fastlmsexample.member.model.ResetPasswordInput;
import com.example.fastlmsexample.member.repository.MemberRepository;
import com.example.fastlmsexample.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @RequestMapping("/member/login")
    public String login() {

        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword() {

        return "member/find_password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = false;
        try{
            result = memberService.sendResetPassword(parameter);
        } catch (Exception e) {
        }
        model.addAttribute("result", result);
        return "member/find_password_result";
    }

    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request
            , MemberInput parameter) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);

        return "member/register_complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request) {

        String uuid = request.getParameter("id");
        System.out.println(uuid);

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);


        return "member/email_auth";
    }


    @GetMapping("/member/info")
    public String list(Model model) {
        List<MemberDto> members = memberService.list();
        model.addAttribute("list", members);

        return "member/info";
    }

    @GetMapping("/member/reset/password")
    public String memberResetPassword(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("id");

        boolean result = memberService.checkResetPassword(uuid);

        model.addAttribute("result", result);

        return "member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = false;
        try {
            result = memberService.resetPassword(parameter.getId(), parameter.getPassword());
        }catch (Exception e) {
        }

        model.addAttribute("result", result);

        return "member/reset_password_result";
    }

}

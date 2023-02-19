package com.example.fastlmsexample;

import com.example.fastlmsexample.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(){
//        String email = "tjddbs1412@naver.com";
//        String subject = "안녕하세요. 가입확인 이메일 입니다.";
//        String text = "<p> 안녕하세요. </p> <p> () 입니다.</p>";
//
//        mailComponents.sendMail(email, subject, text);

        return "index";
    }
}

package com.example.community.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.community.dto.MemberDto;
import com.example.community.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/insertForm")
    public String registerForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/insertForm";
    }


    @PostMapping("/insert")
    public String signup(@ModelAttribute @Valid MemberDto memberDto, BindingResult result) {
        System.out.println(memberDto);
        if (result.hasErrors()) {
            return "member/insertForm";
        }

        memberService.save(memberDto);
        return "member/loginForm";
    }
}

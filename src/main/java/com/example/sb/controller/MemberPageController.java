package com.example.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberPageController {

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm.html";
    }
}

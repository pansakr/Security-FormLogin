package com.example.sb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Authentication auth, Model model){

        if(!(auth == null)){
            System.out.println("email = " + auth.getName());
            System.out.println("권한 = " + auth.getAuthorities());
        }

        return "index.html";
    }
}

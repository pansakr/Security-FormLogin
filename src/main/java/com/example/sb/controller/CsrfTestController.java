package com.example.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CsrfTestController {

    @GetMapping("/csrf")
    public String getCsrf(){
        return "csrf/GetCsrf.html";
    }

    @GetMapping("/add")
    public String add(){
        return "csrf/add.html";
    }

    @PostMapping("/csrf")
    public String postCsrf(){
        return "csrf/PostCsrf.html";
    }
}

package com.example.sb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    // 관리자 권한 테스트 메서드
    @GetMapping("/admin")
    public ResponseEntity<String> adminA(){

        String message = "/admin 접근";

        return ResponseEntity.ok().body(message);
    }
}

package com.example.sb.controller;

import com.example.sb.dto.MemberRequest;
import com.example.sb.dto.MemberResponse;
import com.example.sb.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberRequest memberRequest){

        MemberResponse memberResponse = memberService.signup(memberRequest);

        return new ResponseEntity<>(memberResponse, HttpStatus.CREATED);

        // return ResponseEntity.created().body(memberResponse);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<MemberResponse> myPage(@PathVariable Long id){

        MemberResponse response = memberService.maPage(id);

        return ResponseEntity.ok().body(response);
    }
}

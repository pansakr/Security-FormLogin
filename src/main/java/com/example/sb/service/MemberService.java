package com.example.sb.service;

import com.example.sb.dto.MemberRequest;
import com.example.sb.dto.MemberResponse;

public interface MemberService {

    MemberResponse signup(MemberRequest memberRequest);

    MemberResponse maPage(Long id);
}

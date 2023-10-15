package com.example.sb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequest {

    private String email;

    private String password;

    private String role;
}

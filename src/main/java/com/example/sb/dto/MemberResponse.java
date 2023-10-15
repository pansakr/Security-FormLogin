package com.example.sb.dto;

import com.example.sb.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberResponse {

    private String email;

    private String role;

    public static MemberResponse toDto(MemberEntity save) {
        return MemberResponse.builder()
                .email(save.getEmail())
                .role(save.getRole().toString())
                .build();
    }
}

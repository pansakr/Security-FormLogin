package com.example.sb.service;

import com.example.sb.dto.MemberRequest;
import com.example.sb.dto.MemberResponse;
import com.example.sb.entity.MemberEntity;
import com.example.sb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DefaultMemberService implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberResponse signup(MemberRequest memberRequest) {

        memberRequest.setPassword(passwordEncoder.encode(memberRequest.getPassword()));

        MemberEntity save = memberRepository.save(MemberEntity.toEntity(memberRequest));

        return MemberResponse.toDto(save);
    }

    @Override
    public MemberResponse maPage(Long id) {

        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(RuntimeException::new);

        return MemberResponse.toDto(memberEntity);
    }
}

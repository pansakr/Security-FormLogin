package com.example.sb.service;

import com.example.sb.config.auth.CustomUserDetails;
import com.example.sb.entity.MemberEntity;
import com.example.sb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberEntity memberEntity = memberRepository.findByEmail(username)
                                                    .orElseThrow(() -> new UsernameNotFoundException("예외발생!"));

        return new CustomUserDetails(memberEntity);
    }
}

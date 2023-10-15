package com.example.sb.service;

import com.example.sb.config.auth.CustomUserDetails;
import com.example.sb.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationProviderService implements AuthenticationProvider {

    private final DefaultUserDetailsService user;
    private final PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomUserDetails userDetails = user.loadUserByUsername(email);

        if(checkPassword(userDetails, password, encoder)){
            return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        }else {
            throw new BadCredentialsException("계정 정보가 일치하지 않습니다.");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public boolean checkPassword(UserDetails user, String password, PasswordEncoder encoder){

        return encoder.matches(password, user.getPassword());

    }
}

package com.example.sb.config;

import com.example.sb.config.auth.filter.AfterLogFilter;
import com.example.sb.config.auth.filter.BeforeLogFilter;
import com.example.sb.config.auth.filter.CsrfTokenLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //http.csrf().disable();

        http.addFilterBefore(new BeforeLogFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AfterLogFilter(), BasicAuthenticationFilter.class);
                //.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class);  csrfFilter와 같이 사용하면 오류남 이유는 모르겠음

        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                //.antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/");

        return http.build();
    }

}

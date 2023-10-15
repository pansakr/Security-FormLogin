package com.example.sb.config.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;

// 현재 csrfFilter와 같이 사용하면 제대로 페이지가 응답되지 않는 문제가 있다.
public class CsrfTokenLogger implements Filter {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Object csrf = request.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) csrf;

        logger.info("CSRF token " + token.getToken());
    }
}

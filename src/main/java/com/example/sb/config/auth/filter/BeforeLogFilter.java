package com.example.sb.config.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class BeforeLogFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(Logger.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("=====Before Filter=====");

        chain.doFilter(request, response);
    }
}

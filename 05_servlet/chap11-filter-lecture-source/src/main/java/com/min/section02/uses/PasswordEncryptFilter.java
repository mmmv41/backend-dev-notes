package com.min.section02.uses;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        /* 설명 : 기존의 Request 객체가 아닌 우리가 getParameter() 를 재정의한 Request 객체로 교체한다.*/
        RequestWrapper wrapper = new RequestWrapper((HttpServletRequest) servletRequest);

        // doFilter 를 통해 서블릿이 동작
        filterChain.doFilter(wrapper, servletResponse);

    }
}

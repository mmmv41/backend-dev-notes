package com.min.section01.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/*")     // 모든 요청에 대해 처리되는 필터를 만들고 싶을 때
// @WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "secondFilter")
public class SecondFilter implements Filter {
    public SecondFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("secondFilter init 호출");
    }

    // filterChain : filter 다음에 또 filter 가 있다면 갈 수 있다.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("secondFilter 의 doFilter 호출");

        /* 설명 : FilterChain 에서 제공하는 doFilter 는 다음 필터 또는 서블릿으로 진행하라는 의미
            (자신이 받은 request, response를 다음 필터에게 넘긴다. 다음 필터가 없으면 서블릿으로 가게 끔 한다) */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy 호출");
    }
}

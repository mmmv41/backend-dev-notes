package com.min.section01.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

// Filter 는 인터페이스이기 때문에 implements
/* 설명 : /first 이후 경로는 어떤 것이든 지금의 FirstFilter 를 거치는 요청 경로가 된다. */
//@WebFilter("/first/*")

/* 설명 : @WebFilter 라는 어노테이션을 통해 필터 설정을 할 수 있지만
    필터의 동작 순서를 원하는대로 동작하게 하기 위해서 Servlet 에서는 web.xml 을 활용한 xml 방식의
*   설정을 통해서만 바꿔줄 수 있다.
*   (필터의 동작 순서는 web.xml 에 작성한 filter mapping 의 순서에 따라 동작한다) */
// @WebFilter(filterName = "firstFilter", urlPatterns = "/first/*")
// xml 매핑 방식
@WebFilter(filterName = "firstFilter")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init 호출");
    }

    // filterChain : filter 다음에 또 filter 가 있다면 갈 수 있다.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("FirstFilter 의 doFilter 호출");

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

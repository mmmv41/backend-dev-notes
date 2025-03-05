package com.min.lifecycle.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    /* memo : Servlet LifeCycle
     *   1. 생성 (기본 생성자 실행)
     *      Servlet 객체가 생성됨.
     *   2. 초기화 (init 메소드 호출)
     *   3. 서비스 처리 (service 메소드 호출)
     *      실제 요청을 처리하는 부분
     *   4. 소멸 (destroy 메소드 호출)
     *      서블릿이 제거될 때 실행
     * */

    public LifeCycleTestServlet() {
        System.out.println("annotation 방식 기본생성자 실행!");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메소드 호출!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메소드 호출!");
    }

    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destrroy() 메소드 호출!");
    }
}

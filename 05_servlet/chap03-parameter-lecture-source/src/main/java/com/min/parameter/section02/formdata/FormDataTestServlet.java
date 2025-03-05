package com.min.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명 : tomcat 9 버전 이하는 post 방식 요청일 때 한글이 깨지지 않으려면 UTF-8 로 인코딩 설정 해 주어야 한다. */

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);

        /* 설명 : parameter 들을 한번에 순회하며 확인하고 싶을 때 (키 값) */
        Enumeration<String> keyNames = req.getParameterNames();
        // 어떤 키 값이 넘어오는지 확인할 때
        while (keyNames.hasMoreElements()) {
            System.out.println(keyNames.nextElement());
        }

    }
}

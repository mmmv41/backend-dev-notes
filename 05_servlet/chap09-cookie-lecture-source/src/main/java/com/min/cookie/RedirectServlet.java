package com.min.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명 : 클라이언트의 브라우저에 있는 모든 쿠키값을 request header 에 같이 실려 온다. */
        Cookie[] cookies = req.getCookies();

        String firstName = "";
        String lastName = "";
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());

            /* memo : firstName 을 먼저 쓴 이유 -> cookie.getName() 을 썼을 때 nullPointerException 이 발생할 가능성이 있기 때문 */
            if ("firstName".equals(cookie.getName())) {
                firstName = cookie.getValue();
            } else if ("lastName".equals(cookie.getName())) {
                lastName = cookie.getValue();
            }
        }

//        System.out.println("==== redirect 이후 servlet 에서 ====");
//        System.out.println("firstName = " + firstName);
//        System.out.println("lastName = " + lastName);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>당신의 이름은 ")
                .append(firstName)
                .append("<br> 그리고 성은 ")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();

    }
}

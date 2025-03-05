package com.min.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /* 설명 : MIME 타입과 설정, 인코딩 설정 -> response 에게 미리 알려줘야만 적용이 된다.
         *   jakarta 는 해줄 필요 x */
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");    // 한줄로 적을 수 o

        PrintWriter out = resp.getWriter(); // response 객체로 만든  stream 이 나오게 됨.
        out.print(responseText); // HTML 문자열 출력
        out.flush();    // 스트림을 강제로 비워 데이터 전송
        out.close();    // 출력 스트림 닫음

    }
}

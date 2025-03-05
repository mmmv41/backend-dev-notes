package com.min.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        // 서버에서는 attribute 로 담는다.
        /* 설명
         *   이 부분에서는 id와 pwd에 해당하는 user 의 정보를 DB까지 가서 select 하고 확인하는
         *   비즈니스 로직(BL)이 수행되어야 함. (그 결과는 회원의 정보를 조회해 옴)
         *   우리는 제대로 조회되었다는 가정 하에 'xxx님 환영합니다." 와 같은 메세지를 출력하는 화면 만들어 응답해본다.*/
        req.setAttribute("userName", "밍");

        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp); // forward(여기로, 이걸 들고간다)
    }
}

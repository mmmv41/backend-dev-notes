package com.min.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* memo : 클라이언트가 어떤 요청을 보냈는지 확인하고 싶을 때 -> getMethod() 메소드 사용 가능 */
        String method = req.getMethod(); // 요청 방식 가져오기 (GET, POST 등)
        System.out.println("클라이언트 요청 방식: " + method);

        /* 설명
         *   요청 시 전달되는 헤더라는 것이 가진 정보는 전통적으로 4가지 카테고리로 구분된다.
         *
         *  설명
         *   1. General Header
         *       : 요청 및 응답 모두에 적용되지만 최종적으로는 body에 전송되는 것과는 관련이 없는 헤더이다.
         *   2. Request Header
         *       : 패치 될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더이다.
         *   3. Response Header
         *       : 요청 위치나 서버 응답에 대한 부가적인 정보를 갖는 헤더이다.
         *   4. Entity Header
         *       : 컨텐츠 길이나 MIME 같은 엔티티 바디에 대한 상세 정보를 포함하는 헤더이다.
         *       (GET 요청은 해당되지 x -> body 의 컨텐츠를 나타내기 때문)
         *       (Content-Length, Content-type, Content-Language, Content-EnCoding) */

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName);
        }
    }
}

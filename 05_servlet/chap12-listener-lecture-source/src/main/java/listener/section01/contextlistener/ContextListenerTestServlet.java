package listener.section01.contextlistener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("context listener 확인용 서블릿");

        ServletContext context = req.getServletContext();   // 프로그램 시작과 동시에 호출

        context.setAttribute("test1", "value1");
        context.setAttribute("test2", "value2");
        context.setAttribute("test3", "value3");

        context.removeAttribute("test2");
    }
}

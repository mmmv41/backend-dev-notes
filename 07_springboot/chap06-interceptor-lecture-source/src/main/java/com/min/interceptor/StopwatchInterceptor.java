package com.min.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Locale;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/* memo : 핸들러 인터셉터를 구현하겠다. -> 디폴트 메소드가 존재하므로 오버라이딩 */

/* 설명 :
*   1. bean 을 다룰 수 있다 (필터와의 차이점. 필터는 빈을 이용할 수 없다)
*   2. 핸들러 메소드 직전/직후에 동작하여 전 후 처리를 한다.
*   (forward 및 redirect 이여도 매번 핸들러 메소드 실행 시 동작을 한다.)
*   3. 이후에 진행될 핸들러 메소드의 동작 여부를 제어할 수 있다. (preHandle 의 반환형을 통해)
*   인터셉트를 사용하는 경우(목적)
*   : 로그인 체크, 권한 체크, 프로그램 실행 시간 계산 작업 로그 처리, 업로드 파일 사이즈 처리(리사이징), 로케일(지역) 설정 등
* */
@Component
public class StopwatchInterceptor implements HandlerInterceptor {

    InterceptorTestService testService;

    @Override
    // return false 면 핸들러 메소드가 동작되지 않기 때문 -> preHandle 의 반환형은 boolean 이다.
    // 뭘 반환하느냐에 따라 핸들러 메소드의 동작 유무를 정할 수 있다.
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle 호출함... (핸들러 메소드 이전)");

        /* 설명 : Service bean 에 있는 메소드 호출 */
        testService.test();

        /* 설명 : requestHeader 에서 지역 추출 후
        *   그 사람의 지역 정보(로케일 값) 가 자동으로 넘어온다. */
        Locale locale = request.getLocale();
        System.out.println("locale = " + locale);
        if("ko_KR".equals(locale.toString())) System.out.println("한국인이시군요");

        long startTime = System.currentTimeMillis(); // 메소드가 실행될 때 시간을 변수에 담기
        request.setAttribute("startTime", startTime);   // 리퀘스트에 담으면 핸들러 메소드에도 리퀘스트가 들어가게 되어,리퀘스트 객체는 유지된다.

        /* 설명 : 핸들러 인터셉터는 bean 을 활용할 수 있으며 이후 핸들러 메소드 동작 여부를 반환형으로 제어할 수 있다. */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 호출함... (핸들러 메소드 이전)");
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        /* 설명 : postHandle 의 ModelAndView 는 Handler Method 가 반환한 ModelAndView 에 해당된다. */
        modelAndView.addObject("interval", endTime - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
    /* memo : preHandle - postHandle 등을 하면 인터셉터가 갔다오는데 걸리는 시간 등을 구할 수 있다. */
}

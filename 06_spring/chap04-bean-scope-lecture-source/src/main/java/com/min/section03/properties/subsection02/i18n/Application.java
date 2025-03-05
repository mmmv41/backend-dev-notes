package com.min.section03.properties.subsection02.i18n;

import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* 설명 :
         *   i18n 소프트웨어의 국제화란?
         *   (Internationalization 에서 첫 글자인 I와 마지막 글자인 n 사이에 알파벳 개수가 18개)
         *   소프트웨어를 국제화 하기 위해서는 처리해야 할 작업이 많이 있다.
         *   1. 언어, 지역별 번역
         *   2. OS/Platform 별 인코딩
         *   3. 문자열 치환 방법  */

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* memo : 400 에러가 발생했을 때 빈을 꺼내서 사용할 수 있다.
         *   Locale 에는 접속한, 요청한 사람의 국적이 온다. */
        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR =
                context.getMessage("error.500", new Object[]{"여러분", new java.util.Date()}
                        , Locale.KOREA);

        System.out.println("I18N error.404 메시지 : " + error404MessageKR);
        System.out.println("I18N error.500 메시지 : " + error500MessageKR + "\n");

        /* memo : Date 에 대한 toString 형태도 한국, 미국에 맞춰서 나온다. */
        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS =
                context.getMessage("error.500", new Object[]{"you", new java.util.Date()}
                        , Locale.US);

        System.out.println("I18N error.404 message : " + error404MessageUS);
        System.out.println("I18N error.500 message : " + error500MessageUS);

    }
}

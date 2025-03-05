package com.min.section03.annotationconfig.subsection02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext(
                        "section03/annotationconfig/xml/spring-context.xml");

        // 컨테이너에 들어있는 모든 bean 의 이름(id) 보기 -> resources 를 기준으로 찾는다.
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}

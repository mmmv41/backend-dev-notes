package com.min.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class); // 스프링 컨테이너 생성

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {// 컨테이너 안에 빈이 있다면 빈을 꺼내서 이름을 알려달라는 뜻
            System.out.println("beanName : " + beanName);

        }
    }
}

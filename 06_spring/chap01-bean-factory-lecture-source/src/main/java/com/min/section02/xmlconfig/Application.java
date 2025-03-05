package com.min.section02.xmlconfig;

import com.min.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 어노테이션 방식
public class Application {
    public static void main(String[] args) {
        //resources 위치로 부터의 상대 경로 작성
        ApplicationContext context =
                new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");

        /* memo : 컨테이너에 들어있는 모든 bean 의 이름(id) 보기*/
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /* 설명 : 1. bean의 id를 가지고 컨테이너에서 추출  */
//        MemberDTO member = (MemberDTO) context.getBean("member");// 멤버라는 이름의 빈을 줘. 반환형 -> object. 실제 타입으로 다운 캐스팅 필요

        /* 설명 : 2. bean의 클래스의 메타 정보(bean의 타입)를 전달하여 추출  */
//        MemberDTO member = context.getBean(MemberDTO.class); // 타입만 받고 싶을 때 .class 사용

        /* 설명 : 3. bean 의 id 와 클래스의 메타 정보를 전달하여 추출 (이름과 타입을 전달) */
        MemberDTO member = context.getBean("member", MemberDTO.class);   // 타입을 알려줘서 다운 캐스팅 불필요

        System.out.println("member = " + member);
    }
}

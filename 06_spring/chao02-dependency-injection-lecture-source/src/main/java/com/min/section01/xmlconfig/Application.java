package com.min.section01.xmlconfig;

import com.min.common.MemberDTO;
import com.min.common.PersonalAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new GenericXmlApplicationContext(
                "section01/xmlconfig/spring-context.xml"
        ); // 이 상태에서 spring-context.xml 에 가서 빈을 설정해주면 된다.

        // 빈을 꺼내는 방법 중 하나 
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);

        // 내가 해본 거
        PersonalAccount account = context.getBean("account", PersonalAccount.class);
        System.out.println("account = " + account);
    }
}

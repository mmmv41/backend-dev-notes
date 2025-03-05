package com.min.chap01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    /* memo : @Value 하고 키 값만 쓰면 된다. */
    @Value("${test.value}")
    public String testValue;

    @Value("${test.age}")
    public String testAge;

    /* 설명 : @Value 는 시스템 환경변수도 불러올 수 있다. */
    @Value("${user}")
    public String userName;


    @Bean
    public Object propertReadTest() {
        System.out.println("testValue = " + testValue); // 빈을 만드는데 이게 필요하고,
        System.out.println("userName = " + userName);
        System.out.println("testAge = " + testAge);

        return new Object();
    }

}

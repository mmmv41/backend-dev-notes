package com.min.section01.scope.singleton;

import com.min.common.Beverage;
import com.min.common.Bread;
import com.min.common.Product;
import com.min.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1500);
    }

    @Bean
//    @Scope("singleton")
    /* memo : Scope("prototype") 사용 -> ShoppingCart 가 요청될 떄마다 (getBean("cart") 호출할 때 마다) 새로운 객체 생성되도록 설정
     *   prototype 스코프 빈은 미리 생성되지 x, 요청할 때마다 생성*/
    @Scope("prototype") // bean 스코프를 수정하게 되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}

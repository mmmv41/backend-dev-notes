package com.min.section02.initdestroy;

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
    /* memo : prototype 스코프 빈은 close() 시 destroyMethod가 호출되지 않음 */
    @Scope("prototype") // bean 스코프를 수정하게 되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    /* memo : initMethod -> 빈이 초기화 될 때 메소드 실행, destroyMethod -> 빈이 소멸될 때 메소드 실행
     *   Application에서 context.close() 을 할 때 */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
}
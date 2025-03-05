package com.min.section03.properties.subsection01.properties;

import com.min.common.Beverage;
import com.min.common.Bread;
import com.min.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/* memo : @Propertysource : 프로퍼티 파일을 로드하는 어노테이션
 *   .properties 파일을 로드해서 값을 가져옴.
 */
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {
    /* memo : @Value : 프로퍼티 값을 주입하는 어노테이션
     *   ${} 표기법을 사용해서 프로퍼티 파일에서 값을 가져옴.
     *   @Value 어노테이션을 사용하면 설정 파일에서 값을 자동으로 주입할 수 있음. */
    @Value("${bread.carpbread.name}")
    private String carpBreadName;

    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;

    @Value("${beverage.milk.price}")
    private int milkPrice;

    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    // 바인딩 한다.
    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price}") int waterPrice,
                         @Value("${beverage.water.capacity}") int waterCapacity) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }
}

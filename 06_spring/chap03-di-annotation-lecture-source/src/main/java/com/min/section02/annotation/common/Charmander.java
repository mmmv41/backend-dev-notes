package com.min.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* memo : @Primary : 동일한 타입의 빈이 여러 개일 때, 기본적으로 주입할 빈 지정. */
@Primary
@Component
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("파이리 불공격🔥");
    }
}

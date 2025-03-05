package com.min.section02.functionInterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표 : 표준 함수적 인터페이스 중 Supplier 에 대해 이해하고 사용할 수 있다. */
        /* 설명 : 매개변수 없고 반환값만 있는 메소드 관련 람다식 */

        // return 을 쓰려면 중괄호 {}도 있어야함. {return LocalDateTime.now()}
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2); // 0, 1 둘중 하나만 나옴
            return random == 0 ? false : true;
        };
        System.out.println("랜덤 true of false 생성기 : " + booleanSupplier.getAsBoolean());
    }
}

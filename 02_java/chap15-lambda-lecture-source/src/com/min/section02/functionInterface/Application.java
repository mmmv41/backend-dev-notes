package com.min.section02.functionInterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Application {
    public static void main(String[] args) {

        /* 수업목표 : 표준 함수적 인터페이스 중 Consumer 에 대해 이해하고 사용하기 */
        /* 설명 : 매개변수가 있고, 반환값은 없는 메소드 관련 람다식 */
        Consumer<String> consumer = str ->
                System.out.println(str + "(이)가 입력됨");

        consumer.accept("피카츄");
        consumer.accept("hello");

        BiConsumer<String, LocalTime> biConsumer = (str, time) -> System.out.println(str + "(이)가" + time + "에 입력됨");
        biConsumer.accept("Hello?", LocalTime.now());

        /* 설명
            (int)(Math.random() * 개수) + 초기값
        *   new Random().nextInt(개수) + 초기값 (다운 캐스팅을 할 필요가 없다.) */
        ObjIntConsumer<Random> objIntConsumer = (random, bound) -> System.out.println("1부터 " + bound + "까지의 난수 발생: "
                + (random.nextInt(bound) + 1)); // 여기서 쓰이는 random 은 new Random()
        objIntConsumer.accept(new Random(), 10);


    }
}

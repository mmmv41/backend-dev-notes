package com.min.section02.uses.subsection02.intermidate;

import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 스트림의 중계 연산 . 하나인 map 에 대해 이해하고 사용하기 */
        /* 설명 : 맵(map)은 스트림에 들어있는 데이터를 람다식으록 가공하고 새로운 스트림에 담아주는 메소드이다. */
        IntStream intStream = IntStream.range(1, 10);
        intStream.filter(i -> i % 2 != 0)   // 홀수만. predicate 타입 : 입력을 받아 true, false 형태로 반환.
                .map(i -> i * 5)            // 맵에 걸려서 통과된다. Operator 타입 : 매개변수와 반환형이 일치해야한다.
                .forEach(result -> System.out.println(result + " "));   // forEach 를 통해 출력. Consumer 타입 : 매개변수 o, 반환형 x
    }
}

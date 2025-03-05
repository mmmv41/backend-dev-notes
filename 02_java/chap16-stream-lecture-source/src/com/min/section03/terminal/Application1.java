package com.min.section03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : 스트림의 최종연산 (Terminal Operator) 중 하나인 calculation에 대해 이해하고 사용하기 */
        long count = IntStream.range(1, 10).count(); // 1 ~ 9 까지 카운트
        int sum = IntStream.range(1, 10).sum();

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);

//        OptionalInt max = IntStream.range(1, 10).max();
        /* memo : max값이 없으면 -> empty의 값으로 취급할 수 있다 (0이나 null이 아닌 비어있는 값 제공)
         *   기본자료형도 존재하지 않으면 empty */
        OptionalInt max = IntStream.range(1, 1).max();
        System.out.println("max = " + max); // max = OptionalInt.empty

        int oddSum = IntStream.range(1, 10)   // intStream에 나열된 값 1 ~ 9 중에
                .filter(i -> i % 2 == 1)  // 홀수만 필터를 거쳐서
                .sum();                      // 값을 더함.
        System.out.println("oddSum = " + oddSum);
    }
}

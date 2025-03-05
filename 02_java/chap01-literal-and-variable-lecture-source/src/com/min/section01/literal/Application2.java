package com.min.section01.literal;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 값을 직접 연산하여 출력할 수 있다. */
        System.out.println("====== 정수와 정수의 연산 ======");
        System.out.println(123 * 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(123 % 10);

        System.out.println("====== 실수와 실수의 연산 ======");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0); // 소수점 이하를 보고싶으면
        System.out.println(1.23 % 1.0); // 0.2299999999 이렇게 나옴 -> 소수점을 완벽하게 인지하지 못한다.

        System.out.println("====== 정수와 실수의 연산 ======");
        System.out.println(123 / 5);
        System.out.println(123 / 5.0); // 평균 구할 때 자주 사용 -> 소수점 결과를 보고 싶으면 연산에서 최소 하나는 실수여야 한다.

        System.out.println("====== 문자와 실수의 연산 ======");
        System.out.println('a' + 1); // a는 아스키코드로 97 -> 연산 결과 : 98
        System.out.println('a' % 2); // 97 % 2 = 1

        /* 설명 : 문자열과 문자열의 연산은 '+'만 가능하며 이어붙이기 효과가 발생한다. */
        System.out.println("====== 문자열과 문자열의 연산 ======");
        System.out.println("Hello " + "World!~"); // 문자열을 이어붙인다. concat의 개념

        /* 설명 : 문자열이 중간에 들어간다면 뒤의 나머지도 문자열이 된다. */
        System.out.println("====== 문자열과 다른 형태의 값 연산 ======");
        System.out.println("hello " + 123);
        System.out.println("hello " + true);
        System.out.println(123 + 1 + "hello " + 123.0 + 2);
        System.out.println(123 + 1 + "hello " + (123.0 + 2)); // 3 1 2 순으로 실행

    }
}

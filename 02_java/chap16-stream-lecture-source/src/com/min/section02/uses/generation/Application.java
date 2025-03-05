package com.min.section02.uses.generation;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        /* 수업목표 : 기본 타입 스트림 생성에 대해 이해하고 활용하기 */
        /* 설명
         *   range(시작값, 종료값): 시작값부터 1씩 증가하는 숫자문 종료값 직전(종료값 -1)까지 범위의 스트림 생성
         *   rangeClosed(시작값, 종료값): 시작값부터 1씩 증가하는 숫자로 종료값까지 포함한 스트림 생성
         * */
        IntStream intStream = IntStream.range(5, 10);    // 5 ~ 9
        intStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5L, 10L); // 5 ~ 10
        longStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        /* 설명
         *   Wrapper 클래스 자료형의 스트림이 필요한 경우 boxing도 가능하다.
         *   double(개수) : 난수를 활용한 DoubleSteam 개수만큼 생성하여 반환한다.
         *   boxed() : 기본 타입 스트림인 XXXStream 을 박싱하여 Wrapper 타입의 Stream<XXX>로 변환한다. */
        Stream<Double> doubleStream = new Random().doubles(5).boxed();  // 더블 형으로 바꾼 후
        doubleStream.forEach(value -> System.out.println(value + " "));
        System.out.println();

        /* 설명 : 추가로 두가지 더
         *   1. 문자열을 split 하여 Stream<String>으로 생성 */
        Stream<String> splitStream = Pattern.compile(", ").splitAsStream("html, css, javascript");
        splitStream.forEach(System.out::println);

        /* 설명 :
            2. iterate()을 활용하여 수열 형태의 스트림 생성 */
        // 10부터 시작, limit의 개수만큼 순회한다.
        //  value * 2를 한 뒤 다시 value로 가고 다시 value * 2로 감. -> 반복 구조
        Stream<Integer> intStream2 = Stream.iterate(10, value -> value * 2).limit(10);
        intStream2.forEach(value -> System.out.print(value + " "));

    }
}

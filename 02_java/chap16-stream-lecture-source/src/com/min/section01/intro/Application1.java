package com.min.section01.intro;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : 배열이나 컬렉션은 스트림을 이용할 수 없고 이를 이해해서 활용할 수 있다. */
        String[] sArr = new String[]{"java", "mariaDB", "jdbc"};

        /* 목차 1. 배열로 스트림 생성 */
        /* 설명 : Arrays.stream(배열) : 배열 자료형을 Stream 자료형으로 변환 */
        System.out.println("==== 배열로 스트림 생성 ====");
        Stream<String> strStream = Arrays.stream(sArr); // 스트림으로 바꾼다.

        /* 설명 : forEach는 자신의 매개변수에 정의된 람다식의 매개변수로 stream 의 각 요소들을 자동으로 넘기며 순회(람다식 실행) */
//        strStream.forEach(x -> System.out.println(x));
//        strStream.forEach(System.out::println); // forEach의 람다식에 스트링이 되기전 배열의 요소들을 넘겨준다.

        // for문 처럼 사용할 수 있다.
        Arrays.stream(sArr).forEach(System.out::println);   // Consumer 타입
        System.out.println();

        /* 설명 : stream 으로 관리되는 요소들을 원하는 개수만큼 반복할 수 있다. */
        Stream<String> strStream2 = Arrays.stream(sArr, 0, 2);
        strStream2.forEach(System.out::println);

        /* 설명
         *   Builder를 활용한 스트림 생성
         *   Builder는 static<T>로 되어 있는 메소드이며, 호출 시 타입 파라미터를 메소드 호출 방식으로 전달한다. */
        System.out.println("==== Builder로 스트림 생성 ====");
        Stream<String> builderStream = Stream.<String>builder() // builder 호출 시 제네릭을 걸어야한다.
                .add("java")
                .add("유관순")
                .add("윤봉길")
                .build();
        // builderStream.forEach(x -> System.out.println(x));
        builderStream.forEach(System.out::println);

        /* 목차 2. 컬렉션으로 Stream 생성 */
    }
}

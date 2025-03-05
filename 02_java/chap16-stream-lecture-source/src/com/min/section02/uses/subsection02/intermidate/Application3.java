package com.min.section02.uses.subsection02.intermidate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표 : 스트림의 중계 연산 중 하나인 sorted에 대해 이해하고 사용하기 */
        List<Integer> interList = IntStream.of(5, 10, 99, 2, 1, 35) // 특정한 숫자의 나열 : of int 값들을 원하는 순서를 나열
                .boxed()    // intStream -> Stream 으로 변환. 여기까지가 Integer의 스트림 형태를 만들기 위한 과정
                .sorted(new DescInteger())   // 들어있는 integer의 정렬 기준대로 정렬
                .collect(Collectors.toList());

        // Collectors에서 제공하는 메소드를 쓸 수 있게 해주는 메소드 (toList 형태로 바꾸기 위해 사용).
        // Collection으로 바꿀 때 사용
        System.out.println("정렬 된 Integer List: " + interList);
    }
}

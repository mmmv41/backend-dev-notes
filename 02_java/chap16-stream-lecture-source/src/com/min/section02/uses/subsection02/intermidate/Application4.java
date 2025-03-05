package com.min.section02.uses.subsection02.intermidate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표 : 스트림의 중계 연산 중 하나만 flatMap 에 대해 이해하고 사용할 . 있다. */
        List<List<String>> list = Arrays.asList(    // 리스트 두개를 품은 또다른 리스트 (이차원 리스트. 깊이 2단계)
                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT")
        );
        list.stream().forEach(System.out::println);
        System.out.println("list = " + list);

        List<String> flatList = list.stream().flatMap(Collection::stream) // 하나의 층을 flat 하게 바꾼다. -> 하나의 리스트로 바꾼다.
                .collect(Collectors.toList()); // list 형태로 반환한다.
        flatList.stream().forEach(System.out::println);
        System.out.println("flatList = " + flatList);


    }
}

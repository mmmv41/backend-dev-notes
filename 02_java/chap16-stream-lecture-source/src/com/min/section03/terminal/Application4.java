package com.min.section03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표 : 스트림의 최종 연산 . 하나인 match 에 대해 이해하고 사용할 . 있다. */
        List<String> stringList = Arrays.asList("java", "Spring", "SpringBoot");

        // string 형태가 문자열 안에 존재하는지 확인 -> true, false 반환
        Boolean anyMatch = stringList.stream().anyMatch(str -> str.matches("p"));   // 하나라도 p가 들어있으면 true ??
        Boolean allMatch = stringList.stream().allMatch(str -> str.length() > 4);         // 모두 4를 넘어야 true
        Boolean noneMatch = stringList.stream().noneMatch(str -> str.contains("c"));      // 모두 존재하지 않아야 true

        System.out.println("anyMatch = " + anyMatch);
        System.out.println("allMatch = " + allMatch);
        System.out.println("noneMatch = " + noneMatch);
    }
}

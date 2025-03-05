package com.min.section01.method;

public class Application6 {
    public static void main(String[] args) {

        /* 수업목표 : 반환값이 없는 메소드를 작성할 수 있다.*/
        String result = testMethod();
        System.out.println("result = " + result);

        /* 설명 : 메소드의 반환값을 한번만 쓴다면 굳이 변수에 담지 않아도 됨.*/
        System.out.println("testMethhod() = " + testMethod());
    }

    private static String testMethod() {
        System.out.println("testMethod 메소드 실행됨...");
        return "test";
    }
}

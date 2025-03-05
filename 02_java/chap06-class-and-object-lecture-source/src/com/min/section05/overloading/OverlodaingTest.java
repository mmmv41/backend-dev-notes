package com.min.section05.overloading;

public class OverlodaingTest {

    /* 수업목표
     *   오버로딩(Overloading)에 대해 이해할 수 있다.*/

    /* 설명
     *   오버 로딩이란 ?
     *   동일한 메서드 이름으로 다양한 종류의 매개변수에 따라 처리해야 하는 경우 적용하는 기술이다.
     *
     * 설명.
     *   오버 로딩의 조건?
     *   매개변수의 타입, 개수, 순서를 다르게 작성하여 하나의 클래스 내에 동일한 이름의 메서드를 여러개 작성할 수 있다.
     *   메서드의 헤드부에 있어 시그니처를 제외한 부분이 다르게 작성되는 것은 인정되지 않는다.*/

    public void test() {
    }

//    public String test() {
//    }

    public void test(int num) {
    }


    public void test(int num1, int num2) {
    }
//    public void test(int num2, int num1){}    매개변수의 이름은 무의미하다. (같은 메서드로 인식함)

    public void test(int num, String str) {
    }

    /* 설명
     *   매개변수 타입의 순서가 달라질 떄*/
    public void test(String str, int num) {
    }
}
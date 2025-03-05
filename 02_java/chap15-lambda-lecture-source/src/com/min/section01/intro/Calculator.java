package com.min.section01.intro;

/* 설명 : FunctionalInterface 만 람다식으로 적용이 가능하다. */
// 추상 메소드를 두개 이상 추가하려고 하면 오류가 발생함.
@FunctionalInterface
public interface Calculator {
    /* memo :  Functional Interface */

    int sumTwoNumbers(int first, int second);
//    void test();
}

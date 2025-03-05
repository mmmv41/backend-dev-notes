package com.min.section01.intro;

public class CalculatorImpl implements Calculator {

    // 추상 메소드를 반드시 구현해야함.
    @Override
    public int sumTwoNumbers(int first, int second) {
        return first + second;
    }
}

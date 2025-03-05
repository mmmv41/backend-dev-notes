package com.min.section02;

import com.min.section01.method.Calculator;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : import에 대해 이해하기 */
        Calculator cal = new Calculator();
        int result = cal.plusTwoNumbers(10, 2);
        System.out.println("result = " + result);

        result = Calculator.maxNumberOf(10, 30);
        System.out.println("result = " + result);
    }
}

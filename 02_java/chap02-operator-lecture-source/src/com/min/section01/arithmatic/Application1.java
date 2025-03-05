package com.min.section01.arithmatic;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : 산술 연산자에 대해 이해하고 활용하기 */
        int num1 = 20;
        int num2 = 7;

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));
        System.out.println("num1 % num2 = " + (num1 % num2));   // modulus 연산자

        // 결과를 실수로 나오게하기 위해 num2를 실수형으로 강제 형변환
        // num1은 자동 형 변환 된다.
        double testNum = num1 / (double) num2;
        double transNum = (int) (testNum * 100) / (double) 100;
        System.out.println("testNum = " + testNum);
        System.out.println("transNum = " + transNum);

    }
}

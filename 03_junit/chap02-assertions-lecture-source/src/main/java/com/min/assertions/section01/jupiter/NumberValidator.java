package com.min.assertions.section01.jupiter;

public class NumberValidator {
    // 유효성 검사
    // 보통 서비스 계층에 만든다.
    public void checkDividableNumbers(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}

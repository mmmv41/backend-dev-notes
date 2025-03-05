package com.min.section02.userexception.exception;

// 예외 클래스 -> Exception 상속 받았기 때문에
public class PriceNegativeException extends Exception {
    public PriceNegativeException(String message) {
        super(message); // 2, 부모 클래스인 Exception의 생성자를 호출하는 역할 . Throwable의 detailMessage 변수에 "상품 가격은 음수일 수 없습니다."가 저장
    }
}

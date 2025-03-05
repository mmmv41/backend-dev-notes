package com.min.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws ArithmeticException { // 예외 여러개 발생시킬 수 있으므로 throws
        System.out.println("가지고 계신 돈은 " + money + "원 입니다.");

        if (money >= price) {
            System.out.println(price + "원 상품을 구입하기 위한 금액이 충분합니다.");
            return;
        }
        //System.out.println("호주머니 사정이 딱하군요");

        /* 설명
         *   예외 상황에 Exception을 상속 받는 클래스의 객체를 생성하고 throw 로 발생 */
        // 메소드에게 처리해야하는 일을 매소드를 호출한곳에 던진다.
        // 이 시점에 예외가 발생한 걸 throw를 거쳐 예외 발생한 메서드에서 처리한다.
        // 한번에 하나의 예외만 처리할 수 있다 : throw
        throw new ArithmeticException("호주머니 사정이 딱하군요");
        // 메서드에 헤드부에 적지 않아도 실행 가능함 -> 쓰는게 낫다
    }
}

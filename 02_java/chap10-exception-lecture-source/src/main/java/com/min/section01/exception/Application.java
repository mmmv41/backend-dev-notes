package com.min.section01.exception;

public class Application {
    public static void main(String[] args) throws ArithmeticException {
        /* 수업목표
         *   예외에 대해 이해하고 이를 처리하기 위한 문법을 활용할 수 있다. */
        /* 설명
         *   1. thrwos를 통한 위임
         *   2. try-catch 를 통한 처리
         * */

        ExceptionTest et = new ExceptionTest();
//
        /* 목차
         *   1. throws 로 처리 시*/
//        et.checkEnoughMoney(50000, 10000);

        /* 목차
         *   2. try-catch 로 처리 시 */
        try {

            /* 설명
             *   try 블럭은 처리 할 예외가 발생할 적당한 범위를 감싼다. */

//            et.checkEnoughMoney(10000, 50000);  // 사고 싶은 물건 가격, 현재 가진 돈
            et.checkEnoughMoney(50000, 10000);  // 사고 싶은 물건 가격, 현재 가진 돈
//            System.out.println("예외가 없었군요");
//
        } catch (ArithmeticException e) {

            /* 설명
             *   try 블럭에서 발생한 예외(객체)를 처리하는 부분
             *   예외 객체를 활용하게 되면 해당 예외 객체의 메서드를 사용할 수 있다.*/

            System.out.println("예외가 발생했군요");
            //System.exit(0);  자바 어플리케이션이 즉시 종료되도록 처리

            // e.getMessage() : 예외처리 매개변수에 넣은 말이 출력된다.
            System.out.println("그 예외는 " + e.getMessage() + " 때문이군요");

            /* 설명
             *   예외 메시지와 발생한 문제들을 추적할 수 있게 빨간 글씨와 메시지로 처리되는 방식*/

//            e.printStackTrace();    // 프로그램이 종료되지 않게 처리함
            //}

//        try {
//            int num = 10;   // num 을 사용하려면 num을 try 문 밖에다 적어야한다. (지역 변수이기 때문)
//            System.out.println(num / 0);    //ArithmeticException   발생
//
//        } catch (ArithmeticException e) {   // 다형성의 적용으로 Exception 이라고만 적어도 됨
//            System.out.println("0으로 나눌 수 없습니다");
//            System.out.println(e.getMessage() + " 라고 출력됨");
//        }

            System.out.println("프로그램이 종료됩니다. ");       // 예외 발생시 바로 종료되지 않고 프로그램이 흘러가는지 체크하기 위한 용도
        }
    }
}

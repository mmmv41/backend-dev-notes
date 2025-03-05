package com.min.section02.userexception;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(90000, 50000);
        } catch (Exception e) {
            System.out.println("유효성 검사 시 문제 발생: " + e.getMessage());
        } finally {
            /* 설명
             *   try 구문에서 예외가 발생하든 발생하지 않든 실행할 구문이 있다면 작성하는 부분 */
            System.out.println("finally 블럭의 내용 동작함 ... ");
        }
        System.out.println("프로그램을 종료합니다. ");
    }
}

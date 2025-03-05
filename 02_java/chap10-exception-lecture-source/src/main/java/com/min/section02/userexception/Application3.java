package com.min.section02.userexception;

import com.min.section02.userexception.exception.MoneyNegativeException;
import com.min.section02.userexception.exception.NotEnoughMoneyException;
import com.min.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) {
        ExceptionTest2 et = new ExceptionTest2();
        try {
            et.checkEnoughMoney(90000, 50000);

            /* 설명
             *   multi-catch 구문은 두 개 이상의 예외를 | 를 사용해서 하나의 catch 블럭에서 처리할 수 있다. */
        } catch (PriceNegativeException | MoneyNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } finally {
            /* 설명
             *   try 구문에서 예외가 발생하든 발생하지 않든 실행할 구문이 있다면 작성하는 부분 */
            System.out.println("finally 블럭의 내용 동작함 ... ");
        }
        System.out.println("프로그램을 종료합니다. ");
    }
}

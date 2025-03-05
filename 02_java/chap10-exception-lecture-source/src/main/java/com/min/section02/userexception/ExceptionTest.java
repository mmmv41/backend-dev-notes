package com.min.section02.userexception;

import com.min.section02.userexception.exception.MoneyNegativeException;
import com.min.section02.userexception.exception.NotEnoughMoneyException;
import com.min.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest {
    public void checkEnoughMoney(int price, int money)
            throws Exception {
        if (price < 0) {
            throw new PriceNegativeException(
                    "상품 가격은 음수일 수 없습니다. ");    // 1. 예외 객체가 생성되고 생성자를 호출한다. 메시지가 super(message)로 전달
        }
        if (money < 0) {
            throw new MoneyNegativeException("가지고 있는 돈은 음수일 순 없습니다. ");
        }
        if (money < price) {
            throw new NotEnoughMoneyException("가진 돈보다 상품 가격이 더 비쌉니다. ");
        }

        /* 설명
         *   아무런 예외가 발생(throw)하지 않으면 실행되는 구문 */
        System.out.println("가진 돈이 충분하시군요 고객님 ! 즐거운 쇼핑 되세요 ! ");
    }
}

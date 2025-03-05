package com.min.section3.math;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 사용자 지정 범ㅁ위의 난수를 발생시킬 수 있다. */

        /* 설명 1) 0 ~ 9 까지의 난수 생성
         *   몇개를 생성할건지 곱해준다
         *   random 메소드는 double 타입이므로 int로 강제 형 변환해서 소수점 제거해준다.*/
        int random1 = (int) (Math.random() * 10);

        /* 설명 2) 80 ~ 100 까지의 난수 생성
         *   생성할 난수의 개수 곱하고,
         *   생성할 난수의 초기값을 더한다.*/
        int random2 = (int) (Math.random() * 21) + 80;

        /* 설명 3) -188 ~ 10 까지의 난수 생성
         *   음수의 개수 = 188개 + 0 = 1개 + 양수의 개수 = 10 => 199 */
        int random3 = (int) (Math.random() * (188 + 1 + 10)) - 188;

        System.out.println("random1 = " + random1);
        System.out.println("random2 = " + random2);
        System.out.println("random3 = " + random3);
    }
}

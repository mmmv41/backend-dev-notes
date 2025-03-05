package com.min.section02;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : 복합대입 연산자를 이해하고 활용하기 */
        /* 설명
         *   대입연산자와 산술 복합 대입연산자
         *   '=', '*=', '-=', '/=', '%=', '+='
         * */

        int num = 12;
        System.out.println("num = " + num);     //12

        num = num + 3;
        System.out.println("num = " + num);     //15

        num += 3; // 누적
        System.out.println("num = " + num);     //18

        num -= 3;
        System.out.println("num = " + num);     //15

        num *= 2;
        System.out.println("num = " + num);     //30

        num /= 2;
        System.out.println("num = " + num);     //15

        num %= 2;
        System.out.println("num = " + num);     //1

        /* 설명 : equal(=) 기호는 왼쪽에 오면 단순 대입 기호가 된다 ! (무조건 오른쪽에 쓰기) */
        num = -5;
        System.out.println("num = " + num);     //-5


    }
}

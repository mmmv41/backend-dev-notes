package com.min.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement() {
//        동안 (1부터; 10까지; 1씩증가) {
//            1부터 10까지 반복하며 출력
//        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " 출력");
        }
    }

    public void testForExample() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        int sum = 0;

        sum += num1 * 2 * 1;
        sum += num2 * 2 * 1;
        sum += num3 * 2 * 1;
        sum += num4 * 2 * 1;
        sum += num5 * 2 * 1;

        System.out.println("sum = " + sum);

        /* 설명 : for문을 톯 개선해보기 (규칙적이며 반복적인 코드) */
        int forSum = 0;

        for (int i = 1; i < 6; i++) {
            forSum += i * 2 * 1;
        }

        System.out.println("forSum = " + forSum);
    }

    public void testForExample2() {
        Scanner sc = new Scanner(System.in);

        System.out.print("limit 값 입력: ");
        int limit = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < limit; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}

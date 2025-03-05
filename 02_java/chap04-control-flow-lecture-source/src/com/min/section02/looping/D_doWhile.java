package com.min.section02.looping;

import java.util.Scanner;

public class D_doWhile {
    public void testSimpleDoWhileStatement() {
        do {
            System.out.println("반복문 실행 될까?");
        } while (false);

        System.out.println("반복 종류 이후");
    }

    public void testDoWhileExample() {

        int sumPrice = 0;
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("sumPrice에 담을래 뺄래?");
            System.out.println("1. 담을래(+1000)");
            System.out.println("2. 뺄래(-1000)");
            System.out.println("3. 나갈래");
            System.out.println("번호를 고르시오: ");
            choice = sc.nextInt();
            if (choice == 1) {
                sumPrice += 1000;
            } else if (choice == 2) {
                sumPrice -= 1000;
            }
            System.out.println("현재 sumPrice에는 " + sumPrice);
        } while (choice < 3);
    }
}

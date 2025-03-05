package com.min.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 설명 : 중첩 반복문
         *   2단
         *   2 * 1 = 2
         *   2 * 2 = 4 ...
         *   9단
         *   9 * 1 = 9
         *   9 * 2 = 18 ...
         * */

//        for (int dan = 2; dan <= 9; dan++) {    // 몇단인지
//            System.out.println(dan + "단");
//            for (int su = 2; su <= 9; su++) {  // 곱해지는 수
//                System.out.println(dan + " * " + su + " = " + dan * su);
//            }
//            System.out.println("-------------");
//        }

        for (int dan = 2; dan <= 9; dan++) {    // 몇단인지
            System.out.println(dan + "단");
            printGugudan(dan);
            System.out.println("-------------");
        }
    }

    private void printGugudan(int dan) {
        for (int su = 2; su <= 9; su++) {  // 곱해지는 수
            System.out.println(dan + " * " + su + " = " + dan * su);
        }
    }

    /* 설명 : 별 찍기 해보기
     *       *
     *      **
     *     ***
     *    ****
     *   ***** */

    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오: ");

        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {      //input의 개수만큼 반복한다.

            /* 설명 : 공백 찍기
             *   i = 0 일 때, 공백:4, 별:1
             *   i = 1 일 때, 공백:3, 별:2 */
            printSpace(input - (i + 1), " ");

            printStars((i + 1), "*");
            System.out.println();


            /* 설명 : 별 찍기 */
        }
    }

    private static void printStars(int i, String s) {
        for (int j = 0; j < i; j++) {
            System.out.print(s);
        }
    }

    private static void printSpace(int input, String space) {
        for (int j = 0; j < input; j++) {
            System.out.print(space);
        }
    }

}

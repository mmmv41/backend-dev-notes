package com.min.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public static void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("등급을 입력하세요(G, S, B): ");
        char grade = sc.next().charAt(0);       // 메소드 체이닝 기법. 각각의 문자를 인덱스 체계로 인식.
        System.out.println("grade: " + grade);

        int point = 0;

        /* 설명 : t/f 상황을 저장해서 나중에 활용할 용도로 flag 변수를 추가하기 */
        boolean flag = true;        // default 상황을 인지시키기 위한 변수

        switch (grade) {
            case 'G':
                point += 10;
            case 'S':
                point += 10;
            case 'B':
                point += 10;
                break;
            default:
                flag = false;
                System.out.println("제대로된 입력이 아닙니다.");
        }
        /* 설명 : if를 활용한 조건문에서 실행 구문이 하나라면 중괄호 {} 를 생략할 수 있다. */
        if (flag == true) {
            System.out.println("당신의 등급은 " + grade + "이고, 현재 포인트는 " + point + "입니다.");
        } else {
            System.out.println("회원가입을 해주세요");
        }
    }
}

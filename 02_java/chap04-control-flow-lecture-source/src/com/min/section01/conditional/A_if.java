package com.min.section01.conditional;

import java.util.Scanner;

public class A_if {
    public void testSimpleIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("양수 한 개를 입력하세요: ");
        int input = sc.nextInt();

        //    만약에(입력받은 값이 짝수면)
        //        "짝수입니다."를 출력
        //    }
        if (input % 2 == 0) {
            System.out.println("짝수입니다.");
        }
        //    if (!(input % 2 == 1)) {
        //        System.out.println("짝수입니다.");
        //    }     위의 예제와 같은 의미이다. 여러 방식을 사용해보기
    }

    public void testNestedIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("양수 하나를 입력해 주세요: ");
        int input = sc.nextInt();
        if (input > 0) {
            if (input % 2 == 0) {
                System.out.println("입력 받은 값은 양수이면서 짝수입니다.");
            }
        }

        /* 설명 : 중첩 if만이 정답은 아니다. */
        if (input > 0 && input % 2 == 0) {
            System.out.print("입력 받은 값은 양수이면서 짝수입니다.");
        }
    }
}

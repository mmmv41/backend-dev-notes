package com.min.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기
         *   java.util 패키지는 생략 불가능하므로 -> import 해주기
         *   System.in 은 표준 입출력  */
        Scanner sc = new Scanner(System.in);

        /* 설명 0) next()를 활용한 문자열 입력
         *   next()는 띄어쓰기나 엔터가 인지되지 않는다. (버퍼에 남아있다) */
        System.out.print("소속을 입력하세요: ");
        String className = sc.next();
        System.out.println("className = " + className);

        // 버퍼에 있는 엔터 제거용
        // -> next()를 하고 엔터를 눌렀을 때 nextLine()은 엔터를 인식하기 때문에 제거용 nextLine()을 하나 만들어서 엔터를 제거해준다.

        sc.nextLine();
        /* 설명 1): nextLine()을 활용한 콘솔(console)에서의 문자열 입력 */
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("name = " + name);

        /* 설명 2): nextInt()를 활용한 정수 입력 */
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /* 설명 3) : nextDouble()을 활용한 실수 입력 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("height = " + height);
    }
}

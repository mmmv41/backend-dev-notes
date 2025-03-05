package com.min.section01.method;

public class Application3 {

    /* 설명
     *   전역변수
     *   모든 메소드에서 사용 가능
     *   무조건 static이 붙어야한다.-> ? */
    static int global = 10;

    // 메소드 안이 지역의 시작
    public static void main(String[] args) {

        /* 수업목표 : 메소드 전달인자(argument)와 매개변수(parameter)에 대해 이해하기
         *   메소드 호출 시 활용할 수 있다.*/
        /* 설명
         *   변수를 선언한 위치에 따라 구분할 수 있다.
         *   1. 지역변수
         *   2. 전역변수
         *   3. 매개변수
         * */

        System.out.println("전역변수: " + global);

        Application3 app3 = new Application3();
        app3.testMethod(13);    // 13은 호출하면서 쓰이는 인자 => 전달인자
        app3.testMethod(11);
        app3.testMethod('a');

        /* 설명
         *   지역변수 */
        int local = 10;
        System.out.println("지역 변수: " + local);
    }

    /* 설명 : int age 는 매개체 역할을 한다
        => 매개변수 (매개변수는 지역변수이다) */
    public void testMethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}

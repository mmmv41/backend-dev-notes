package com.min.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        // 한줄 주석 (코드 설명)
        // 주석은 한칸 띄우고 적는게 좋다.
        /* 범위 주석 (개념 설명)
         * 여기도 주석
         * */

        /* 수업목표 : 여러가지 값의 형태를 출력할 수 있다.
         * 목차 1) 숫자 형태의 값
         * 목차 1-1) 정수 형태의 값 출력  */
        System.out.println(123);

        /* 목차 1-2) 실수 형태의 값 출력 */
        System.out.println(1.234);

        /* 목차 2) 문자 형태의 값 출력 */
        System.out.println('a'); // 문자는 '' 사용
        System.out.println('1');
        System.out.println('\u0000'); // 값이 없는 문자 -> 네모로 뜸

        /* 목차 3) 문자열 형태의 값 출력 */
        System.out.println("안녕하세요"); // 문자열은 "" 사용
        System.out.println("a");
        System.out.println(""); // ""는 아무것도 넣지 않아도 에러 발생 x, ''는 에러 발생

        /* 목차 4) 논리 형태의 값 출력 */
        System.out.println(true);
        // System.out.println("true"); // 논리형이 아닌 문자열이다.
        System.out.println(false);
        // System.out.println("false");

    }
}

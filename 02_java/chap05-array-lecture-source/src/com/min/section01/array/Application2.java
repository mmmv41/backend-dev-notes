package com.min.section01.array;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 배열의 사용방법을 익혀 배열을 사용할 수 있다. */
        /* 설명
         *   배열의 사용방법
         *   1. 배열의 선언
         *   2. 배열의 크기 할당
         *   3. 배열의 인덱스 공간에 값 대입 */

        int[] iArr;
        char cArr[];        // []의 위치는 변수명 뒤에 써도 성립하지만 지양하기.

        iArr = new int[5];  // 0 ~ 4 까지의 인덱스로 각 칸을 구분
        cArr = new char[5];

        System.out.println("iArr = " + iArr);
        System.out.println("cArr에 담긴 값: " + Arrays.toString(cArr));     // char의 기본형은 \u0000 이다.

        System.out.println("cArr의 주소를 10진수 형태로 보기: " + cArr.hashCode());    // 주소값을 10진수로 바꿔준다.

        /* 설명
         *   NullPointerException 발생
         *   . 이 가리킨다는 뜻인데, null 값을 가리키라고 하기 때문에 에러가 발생한다.  */
        // 참조자료형의 기본 값은 null 이다.
        cArr = null;
        System.out.println("cArr의 값을 비우고 (null) 보면: " + cArr.hashCode());

    }
}

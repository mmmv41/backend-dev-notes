package com.min.section01.array;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표 : 배열에 초기화 되는 자료형별 기본값을 이해할 수 있다. */
        /* 설명
         *   값의 형태별 기본값
         *   정수 :0
         *   실수 : 0.0
         *   논리 : false
         *   문자 : \u0000
         *   참조(String) : null -> String[] sArr = new String[5] -> 각각의 영역에 null이 들어가있다.*/

        /* 설명 : 선언과 동시에 크기 할당 및 초기화를 한번에 진행하고 싶을 때 */
        int[] iArr = {10, 11, 12, 13, 14};
        int[] iArr1 = new int[]{10, 11, 12, 13, 14};    // 이렇게 쓰는게 정석이지만, 위의 예제처럼 사용할 수 있다.

        /* 설명 : new int[] 을 생략하면 안되는 경우 */
        // test({10, 11, 12, 13, 14});     // 오류가 발생 -> new int[] 를 반드시 적어주자
        test(new int[]{10, 11, 12, 13, 14});

        /* 설명 1) 단순 for문 */
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }

        /* 설명 2) 향상된 for문(foreach문)
            변수를 활용해 배열의 전체를 순회할 떄 사용하면 좋다.
            일반 for문과는 다르게 반복 횟수를 지정할 수 없다.
        *   num은 한번쓰고 사라지는 지역변수이다.*/
        for (int num : iArr) {
            System.out.println(num);
        }

        /* 설명 3) 배열의 값들을 단순 확인 */
        System.out.println(Arrays.toString(iArr));
    }

    /* 설명
     *   배열의 '주소값'을 전달 받을 수 있는 매개변수
     *   주소값이 넘어감. 진짜 배열이 넘어가는 것이 아니다 !
     *  얕은 복사가 일어난다.
     *  call by reference 라고 부른다 */
    public static void test(int[] arr) {

    }
}

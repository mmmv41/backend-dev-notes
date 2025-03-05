package com.min.section04.overflow;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표 : 오버플로우에 대해 이해할 수 있다. */
        /* 설명
         *   자로형 별 값의 최대 범위를 벗어나는 경우
         *   발생한 carry를 버림처리하고 부호 비트를 반전시켜 순환한다.
         * */

        /* 설명 : 오버 플로우 */
        byte num1 = 126;    // -128 ~ 127

        num1++;     // num1에 1를 더해서 다시 num1에 담는다. (num1 = num1 + 1) -> 에러나기 때문에
        System.out.println(num1);

        num1++;     // 오버 플로우 발생 -> -128
        System.out.println(num1);

        /* 설명 : 언더플로우(최소 -> 최대) */
        num1--;     // num1 = num1 - 1; -> 127
        System.out.println(num1);

        /* 설명 : 강제 형 변환 (byte로) */
        num1 = (byte) (num1 = 1);
    }
}

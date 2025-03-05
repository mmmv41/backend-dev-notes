package com.min.section05.typecasting;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : 자동 형 변환 규칙에 대해 이해하기
         *  작은 자료형 -> 큰 자료형은 자동 형 변환 */

        byte bNum = 1;      //int를 byte에 담지만, 단순 리터럴일 경우 성립한다.

        short sNum = bNum;  // short sNum = (short) bNum 이렇게 자동 형 변환됨.

        int iNum = sNum;

        /* 설명 : 연산 시에도 자동으로 큰 자료형에 맞춰서 낮은 자료형이 자동 형 변환 된다. */
        int num1 = 10;
        long num2 = 20L;

        long result1 = num1 + num2;     // long(num1) 이 자동으로 이루어진다.
        System.out.println("result1 = " + result1);

        /* 설명 : 문자형은 int형으로 자동 형 변환이 가능하므로 유니코드를 알 수 있다. */
        int uniNum = 'f';       // char 인 f를 int로 변환
        System.out.println("uniNum = " + uniNum);
    }
}

package com.min.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 강제 형 변환 규칙에 대해 이해하기 */
        /* 설명
         *   강제 형 변환
         *       바꾸려는 자료형으로 캐스팅 연산자(자료형)을 이용하여 형변환한다.
         * */

        long lNum = 8000000000L;
        int iNum = (int) lNum;      // 데이터 손실 발생 -> 경우에 따라 부호 및 값까지 바뀜
        System.out.println("iNum = " + iNum);

        float avg = 31.235f;
        int floorNum = (int) avg;   // 실수를 정수로 강제 형 변환하면 소수점이 사라진다.
        System.out.println("floorNum = " + floorNum);
    }
}

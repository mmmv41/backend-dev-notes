package com.min.section02.variable;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 변수를 선언하고 값을 할당하여 사용할 수 있다. (feat. 자료형(type)) */

        /* 목차 1) 정수를 취급하는 자료형 */
        byte bNum;      // 1byte
        short sNum;     // 2byte
        int iNum;       // 4byte
        long lNum;      // 8byte

        /* 목차 2) 실수를 취급하는 자료형 */
        float fNum;     // 4byte
        double dNum;    // 8byte

        /* 목차 3) 문자를 취급하는 자료형 */
        char ch;        // 2byte

        /* 목차 4) 논리값를 취급하는 자료형 */
        boolean isTrue; // 1byte (긍정 의문문 형태로 변수명을 사용할 것)

        /* 목차 5) 문자열을 취급하는 자료형 */
        String str;

        /* 설명 : 각 변수에 값 대입해보기 */
        bNum = 1;
        sNum = 2;
        iNum = 4;
        lNum = 2200000000L;  // L을 붙여야 long이라고 인식 (안붙였을 시 21억 이상이면 오류가 뜬다)

        fNum = 3.14f;
        // double형을 float형에 담을 수 x -> f 붙여서 float형으로 인식시키기. double -> float (8byte -> 4byte)

        dNum = -3.14;

        ch = 'a';
        ch = 97;        // char는 숫자를 담을 수 있음. 양수만 가능 (아스키 코드, 유니코드 체계는 음수가 없다)

        isTrue = true;

        /* 설명 : 변수를 활용한 합계(sum), 평균(avg) 출력해보기 */
        int kor = 90;
        int math = 80;
        int eng = 75;

        int sum = kor + math + eng;
        System.out.println("합계: " + sum);

        /* 설명 : 연산 시 소수점을 보여주고 싶으면 최소 하나는 실수형으로 계산해야한다. */
        double avg = sum / 3.0;     // 결과 -> 81.66666666666667
        double avg2 = sum / 3;     // 결과 -> 81.0

        System.out.println("평균 = " + avg);

    }
}

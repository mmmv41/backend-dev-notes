package com.min.section05.parameter;

import java.util.Arrays;

public class ParameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받아 수정한 값: " + num);
    }

    public void testPrimitiveArrayTypeParameter(int[] iArr) {
        iArr[0] = 100;
        System.out.println("메소드 내에서 수정 후: " + Arrays.toString(iArr));
    }

    public void testClassTypeParameter(Rectangle rectangle) {
        rectangle.calcArea();
        rectangle.calRound();
    }

    /* 설명
     *   가변인자는 넘어온 인자들을 받아내어 배열로 바꿔준다.*/
    public void testVariableLengthArrayParameter(String... str) {   // String 값을 받아내는 가변 인자
        System.out.println("넘어온 인자들 출력: " + Arrays.toString(str));
    }
}
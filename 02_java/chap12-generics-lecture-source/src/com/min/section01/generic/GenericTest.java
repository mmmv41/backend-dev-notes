package com.min.section01.generic;

// 객체를 생성할 때 타입을 지정해주면 됨.
// GenericTest<Integer> g = new GenericTest();

/* 설명
 *   제네릭 클래스의 다이아몬드 연산자(<>) 에 들어갈 수 있는 4가지 타입
 *   1. E : Element
 *   2. T : Type
 *   3. K : Key
 *   4. V : Value
 * */

import java.util.ArrayList;

public class GenericTest<T> {
    private T value;

    public GenericTest() {
        ArrayList<T> list = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

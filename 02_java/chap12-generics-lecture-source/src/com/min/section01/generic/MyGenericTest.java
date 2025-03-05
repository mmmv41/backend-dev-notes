package com.min.section01.generic;

// 모든 것을 받고, 내보낼 수 있음
// 어떤 값을 집어 넣더라고
// 기본 자료형을 넣어도 오토 박싱에 의해 가능

/* 설명
 *   Object 형을 활용해 구현의 편리성은 있지만 타입 안정성은 보장되지 않는다. */
public class MyGenericTest {
    private Object value;

    public MyGenericTest() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

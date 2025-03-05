package com.min.section04.override;

public class SubClass extends SuperClass {

    /* 설명
     *   부모 메서드의 예외 클래스와 같은 레벨일 땐 문제 X */
//    @Override
//    public void method() throws IOException {
//    }

    /* 설명
     *   부모 메서드와 달리 예외를 발생시키지 않아도 문제 X */
//    @Override
//    public void method()  {
//    }


    /* 설명
     *   부모 메서드보다 더 낮은 레벨(자식 예외 클래스)을 발생시켜도 문제 X */
//    @Override
//    public void method() throws FileNotFoundException {
//    }

    /* 설명
     *   부모 메서드보다 더 높은 레벨(부모 예외 클래스)을 발생시키면 문제 O(컴파일 에러 발생) */

//    @Override
//    public void method() throws Exception {
//    }

}

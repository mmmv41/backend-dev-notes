package com.min.section01.intro;

public class Application {
    public static void main(String[] args) {
        /* 수업목표 : 람다식에 대해 이해하고 활용할 수 있다 (Functional Interface)
         *   Functional Interface : 추상 메소드가 단 하나 있는 인터페이스(어노테이션을 붙일 수 있다), 이걸로만 람다식을 작성할 수 있다. */

        /* 목차 1. 인터페이스를 구현하는 클래스로 하위 구현체를 만드는 방법
            (자식 클래스 필요 -> 여기서는 CalculatorImpl 라는 자식 클래스가 존재 ) */
//        Calculator cal = new Calculator();
        Calculator cal = new CalculatorImpl();
        System.out.println("10과 20의 합은? " + cal.sumTwoNumbers(10, 20));   // 동적 바인딩 발생

        /* 목차 2. 익명 클래스(이름이 없는 클래스)를 활용한 방식(자식(구현) 클래스 없애기. 인터페이스 타입으로 하위 구현체 생성)
         *   생성자로 객체를 만드는 것처럼 보이나 이름이 없는 클래스로 객체를 만드는 방식, 객체를 만드는 시점에 일회성으로 사용함 */
        Calculator cal2 = new Calculator() {
            @Override
            public int sumTwoNumbers(int first, int second) {
                return first + second;
            }
        };
        System.out.println("20과 30의 합은(익명클래스)?" + cal2.sumTwoNumbers(20, 30));

        /* 목차 3. 람다식을 활용한 방식 (메소드명이 없는 방식)
         *  (구현해야할 메소드가 하나밖에 없기때문에 가능, 따라서 메소드가 하나인 FunctionalInterface 여야만 한다.)
         *  람다식은 익명함수로 이름을 별도로 작성하지 않지만 인터페이스의 하위 구현체를 생성하며 유일하게 있는 추상메소드를 오버라이딩 하는 개념이기 때문에 익명함수가 가능하다.
         *  즉, 람다식을 활용하기 위한 인터페이스는 추상 메소드를 단 하나만 가져야 한다.
         *   그런 인터페이스를 FunctionalInterface 라고 한다. */
        /* 설명
         *   기본 람다식 규칙
         *   1. 매개변수의 소괄호() 는 생략할 수 없지만 매개변수가 하나인 추상메소드는 소괄호도 생략 가능하다 (ex. ex -> 1 + x;)
         *   2. 구현하는 메소드의 바디부분에서 실행 구문이 하나일 경우 중괄호 {} 가 생략 가능하다.
         *   3. 실행 될 마지막 구문이 리터럴 형태로 끝나고 추상메소드에 반환형이 있을 경우 return이 생략 가능하다. */
        /* memo : 매개변수가 없거나, 두개 이상일때는 매개변수 타입을 생략할 수 있다. -> 타입 추론 기법 */

//        Calculator cal3 = (int first, int second) -> {return first + second;};
        Calculator cal3 = (first, second) -> first + second;
        System.out.println("2와 4의 합은(람다식)? " + cal3.sumTwoNumbers(2, 4));
    }
}

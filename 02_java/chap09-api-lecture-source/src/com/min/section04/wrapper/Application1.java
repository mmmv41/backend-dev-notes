package com.min.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   Wrapper 클래스에 대해 이해할 수 있다. */
        int intValue = 20;

        /* 설명
            기본 자료형을 Wrapper 클래스 자료형으로 변환할 수 있다. (박싱, boxing) */
        Integer autoBoxingInt = 20;     // 오토 박싱 (auto-boxing)
        Integer boxingInt2 = Integer.valueOf(intValue);     // 기본 자료형 -> wrapper 클래스 : 박싱

        /* 설명
         *   Wrapper 클래스 자료형을 기본자료형으로 변환할 수 있다. (언박싱, unboxing) */
        int autoUnboxingInt = autoBoxingInt;        // 오토 언박싱(auto-unboxing)
        int unboxingInt2 = boxingInt2.intValue();

        anythingMethod(20);

        /* 설명
         *   Wrapper 클래스 주소값 비교 */
        Integer integerTest = 30;
        Integer integerTest2 = 30;

        System.out.println("== 비교: " + (integerTest == integerTest2));
        System.out.println("equals() 비교: " + integerTest.equals(integerTest2));
        System.out.println("integerTest 주소: " + System.identityHashCode(integerTest));

        /* 설명
         *   모든 Wrapper 클래스들도 constant pool 을 활용해 동등 객체는 하나만(동일 인스턴스로) 저장한다.
         *  System.identityHashCode() : 객체의 내부 주소를 기반으로 해시 값을 반환*/
        System.out.println("integerTest2 주소: " + System.identityHashCode(integerTest2));
    }

    // 오토 박싱, 다형성이 일어나 매개변수로 들어가게 된다.
    /* 설명
     *   int -> integer (오토 박싱) -> Object (다형성)
     *   obj의 toString()을 사용한게 아니라 Integer의 toString()을 사용한 것 -> 동적 바인딩
     *   컴파일 시에는 정적 바인딩으로 부모인 obj의 toString()이 바인딩되지만, 런타임 시에는 동적 바인딩으로 자식인 Integer의 toString()이 실행된다. */
    private static void anythingMethod(Object obj) {
        System.out.println("obj: " + obj.toString());
    }
}

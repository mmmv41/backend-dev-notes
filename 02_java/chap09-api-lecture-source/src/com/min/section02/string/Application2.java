package com.min.section02.string;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표
         *   문자열 객체를 생성하는 다양한 방법을 숙지하고 인스턴스가 생성되는 방식을 이해할 수 있다. */
        /* 설명
         *   문자열 객체를 만드는 방법
         *   1. "" 리터럴 형태 : 상수 풀에 생성됨. 동일한 값을 가지는 인스턴스(동등(equals, hashcode가 오버라이딩 되어있다.))
         *      (일종의 singleton 개념, 상수풀(constant pool) 활용)
         *   2. new String("") 형태 : 매번 새로운 인스턴스를 생성한다.(주소값이 매번 다름)
         * */

        String st1 = "java";
        String st2 = "java";
        String st3 = new String("java");
        String st4 = new String("java");

        System.out.println("str1 == str2: " + (st1 == st2)); // 인스턴스가 1개이고, 주소값이 같다. 하나를 저장해두고 동등 객체가 들어오면 그 자리를 대체한다.
        System.out.println("str2 == st3: " + (st2 == st3));
        System.out.println("str3 == st4: " + (st3 == st4));

        System.out.println("문자열 비교는 equals()를 사용하자: " + st2.equals(st3));
        System.out.println("hashCode()도 확인: " + st2.hashCode() + ", " + st3.hashCode());

        /* 설명
         *   문자열은 불변객체(immutable object)로 변화를 주면 항상 새로운 객체(인스턴스)가 생성된다. */
        String str = "apple";
        System.out.println(System.identityHashCode(str));
        str += ", banana";
        System.out.println(System.identityHashCode(str));
    }
}

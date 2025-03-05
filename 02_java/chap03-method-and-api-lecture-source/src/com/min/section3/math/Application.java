package com.min.section3.math;

public class Application {
    public static void main(String[] args) {

        /* 수업목표 : Math 클래스에서 제공하는 static 메소드를 호출할 수 있다. */

        // double result = java.lang.Math.abs(-32.1);

        /* 설명 : 다른 패키지에 있는 api 클래스는 import 또는 풀 클래스명을 써야하지만 java.lang 패키지는 생략 가능
         *   Math에서 제공하는 메소드는 import 없이 사용할 수 없다.*/
        double result = Math.abs(-32.1);

        /* 설명 : 최대값, 최소값 출력 */
        System.out.println("10과 20 중 더 작은 것은 " + Math.min(10, 20));
        System.out.println("20과 30 중 더 큰 것은 " + Math.max(20, 30));

        /* 설명 : 난수 생성 */
        System.out.println("난수 생성: " + Math.random());
    }
}

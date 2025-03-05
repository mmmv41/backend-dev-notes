package com.min.section01.method;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표 : 여러개의 전달인자를 이용한 메소드 호출을 할 수 있다.*/

        Application4 app4 = new Application4();
        app4.testMethod("민경", 27, '여');

        /* 설명
         *   지역변수의 변수명은 매개변수의 변수명과 달라도 됨.
         *   하지만 보통은 같게 맞추는 편이다.*/
        String name = "유관순";
        int age = 20;
        char gender = '여';
        app4.testMethod(name, age, gender);
    }

    public void testMethod(String name, int age, final char gender) {
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세 이며, 성별은 "
                + gender + "입니다.");
    }
}

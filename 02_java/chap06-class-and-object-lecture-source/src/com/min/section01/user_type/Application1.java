package com.min.section01.user_type;

import java.util.Arrays;

public class Application1 {

    /* 설명
     *   객체 지향 프로그래밍(OOP) 란?
     *   OOP(Object Oriented Programming Language)
     *   : 추상화, 캡슐화, 상속, 다형성을 적용하여 유지보수성을 고려한 응집력 높고 결합도 낮은
     *   객체 위주의 개발 방식을 적용한 프로그래밍
     *
     *  설명
     *   객체 지향의 특징(4대 특징)
     *   - 추상화(Abstraction) 추상화를 제외하면 3대 특징
     *   - 캡슐화(Encapsulation)
     *   - 상속(Inheritance)
     *   - 다형성(Polymorphism)
     * */
    public static void main(String[] args) {
        String id = "user01";
        String pwd = "pass01";
        String name = "민경";
        int age = 25;
        char gender = '여';
        String[] hobbies = new String[]{"축구", "볼링", "테니스"};

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("hobbies = " + Arrays.toString(hobbies));

        /* 설명
         *   이렇게 변수들로만 관리할 때 발생할 수 있는 문제점
         *   1. 많은 변수들을 관리하기 어렵다. (한 묶음으로 생각하거나 코딩할 수 없다)
         *   2. 메소드의 전달인자로 전달할 값이 많으므로 매개변수의 개수가 늘어난다 -> 리팩토링 필요할 수 있음
         *   3. 메소드의 반환형으로는 하나의 타입만 가능하지만, 현재의 변수들로는 불가능하다  */

        Member member1 = new Member();
        Member member2 = new Member();

        /* 설명 : 사람 한명씩 접근해 이름을 부여하는 코드 */
        member1.name = "배고파";
        member2.name = "예몽";

        /* 설명 : 예몽씨만 완성해보자 */
        member2.id = "user02";
        member2.pwd = "pass02";
        member2.age = 25;
        member2.gender = '여';
        member2.hobbies = new String[]{"멍 때리기", "누워있기"};

        System.out.println("예몽씨의 이름과 나이를 알려주세요: " + member2.name + "이구요, 나이는 "
                + member2.age + "입니다. 취미는 " + member2.hobbies[1] + "랍니다. ^^");

        // 얕은 복사
        /* 설명 : 하나의 묶음으로 전달할 수 있고(매개변수 1개) 반환할 수 있다. */
        Member renameMemeber = test(member2);
        System.out.println("이름: " + renameMemeber.name);
        System.out.println("나이: " + renameMemeber.age);
    }

    private static Member test(Member member2) {
        System.out.println("개명하기");
        member2.name = "예몽몽";
        return member2;
    }
}

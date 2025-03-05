package com.min.section03.reference;

import java.util.function.Function;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표 : 기존에 존재하는 생서자를 참조한 람다식을 할용할 수 있다. */
//        Function<String, Member> costMember =
//         x -> {return new Member(x);};
//         x -> new Member(x);

        /* memo : 제네릭 타입을 보고 Member의 타입에 맞는 생성자를 호출
         *   첫번째 제네릭이 String이면 생성자 중 매개변수를 String으로 받는 생성자라고 판단 */

        Function<String, Member> costMember =
                Member::new;

        Member member1 = costMember.apply("A"); // 이 시점에 객체가 생성되는 것
        System.out.println("member1 = " + member1); // 스트링을 가지고 필요한 생성자가 뭔지 판단함

        Member member2 = costMember.apply("B"); // 이 시점에 객체가 생성되는 것
        System.out.println("member1 = " + member2);
    }
}
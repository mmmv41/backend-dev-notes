package com.min.section03.terminal;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Application5 {
    public static void main(String[] args) {

        /* 설명 : 메소드 참조 관련 추가 설명 (람다식 관련) */
        BiConsumer<Member, String> biConsumer;
        biConsumer = Member::setMemberId;
        biConsumer = (x, y) -> x.setMemberId(y);

        Consumer<String> consumer;
        Member m = new Member("i", "홍길동"); // 객체 하나의 setter만 쓰려면 수정할 값만 넣어주면됨.
        consumer = m::setMemberId;  // 객체가 정해져서 사용하려면 참조 자료형 변수 사용 가능
        consumer = (x) -> m.setMemberId(x);
    }
}

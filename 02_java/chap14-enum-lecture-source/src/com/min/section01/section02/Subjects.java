package com.min.section01.section02;

public enum Subjects {
    JAVA,   // 객체를 가지고 있음. 싱글톤
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT; // 메소드 혹은 생성자가 있으면 ; 를 써줘야한다. (없으면 ; 생략 가능)

    /* memo : 생성자 만들기
     *  enum이 처음 사용될 때(클래스가 로드될 때), 모든 상수에 대해 생성자가 실행된다.
     *   생성자가 호출되면 필드 각각에 객체가 할당된다. */
    Subjects() {
        System.out.println("기본 생성자 실행됨 ...");
    }

    @Override
    public String toString() {
        return "@@@@" + this.name() + "@@@@";
    }
}

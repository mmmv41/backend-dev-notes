package com.min.section01.conditional;

public class Application1 {
    public static void main(String[] args) {
        A_if aClass = new A_if();       // 이 줄이 실행될 때 A_if 클래스가 인식된다.

        /* 설명 : 단독 if문 흐름 확인용 메소드 호출 */
        //  aClass.testSimpleIfStatement();

        /* 설명 : 중첩 if 문 흐름 확인용 메소드 호출 */
        //  aClass.testNestedIfStatement();

        // 클래스 생성전에 이 구문을 작성해주고 option + enter 를 하면 자동으로 B_ifElse 클래스가 생성됨
        B_ifElse bClass = new B_ifElse();

        /* 설명 : 단독 if-else 문 흐름 확인용 메소드 호출 */
        //  bClass.testSimpleIfElseStatement();

        /* 설명 : 중첩 if-else문 흐름 확인용 메소드 호출 */
        //  bClass.testNestedIfElseStatement();

        C_ifElseIf cClass = new C_ifElseIf();
        /* 설명 : 단순 if-else 문 흐름 확인용 메소드 호출 */
        //  cClass.testSimpleIfElseIfStatement();

        /* 설명 : 중첩 if-else if 문 흐름 확인용 메소드 호출 */
        //  cClass.testNestedIfElseIfStatement();

        /* 설명 : static 메소드로 switch 문 흐름 확인용 메소드 호출 */
        D_switch.testSimpleSwitchStatement();
    }
}

package com.min.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표 : Stack 에 대해 이해하고 사용하기 */
        /* 설명
         *   Stack 이란?
         *   후입선출 또는 선입선출의 구조로 push(), pop(), peek()등의 메소드를 활용하여 자료를 처리할 수 있다.
         *  peek() : 맨 마지막에 쌓인걸 확인한다.
         * */
        // List의 후손이지만, push 를 사용한다. 
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        System.out.println("integerStack = " + integerStack);

        System.out.println(integerStack.peek());    // peek() : 가장 위에 있는 값을 확인한다.

        /* 설명 : Stack은 마지막부터 하나씩 순차적으로 카운팅 한다.
         *   동등 비교를 통해 비교한다.
         *   Integer안에 equals()와 hashcode()가 구현되어있기 때문에 비교가능
         *   다른 클래스를 사용하려면 (e,h)가 오버라이딩되어 있어야 한다. */
        System.out.println(integerStack.search(2)); // search(2) : 위에서 두번째의 값을 찾는다

        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
//        System.out.println("pop(): " + integerStack.pop()); //EmptyStackException 발생
    }
}

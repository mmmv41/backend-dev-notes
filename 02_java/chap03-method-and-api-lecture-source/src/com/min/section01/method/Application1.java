package com.min.section01.method;

public class Application1 {
    public static void main(String[] args) {

        /* 설명 : static은 자바가 처음부터 인식하는 것 */
        /* 수업목표 : 메소드의 호출 흐름에 대해 이해하기 */
        System.out.println("main() 시작함...");
        methodA();
        System.out.println("main() 종료함...");
    }

    public static void methodA() {

        // main에서 호출하지 않으면 실행되지 않는다.
        // methodA()를 public void methodA()라고 하면 -> 비 static 이기 때문에
        // main에서 호출시 오류가 발생 -> 따라서 public static void methodA() 라고 해줘야한다.
        System.out.println("methodA() 호출됨...");
        methodB();
        System.out.println("methodA() 종료됨...");

    }

    public static void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
}

package com.min.ex;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");

        System.out.println(stack.pop()); // 출력: World
        System.out.println(stack.pop()); // 출력: Hello
    }
}

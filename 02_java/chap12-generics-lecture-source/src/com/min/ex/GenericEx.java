package com.min.ex;

public class GenericEx {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(10);
        box.printItem();
        int value = box.getItem();
        System.out.println(value);

        Box<String> box2 = new Box<>("Hello");
        box2.printItem();
        String value2 = box2.getItem();
        System.out.println(value2);
    }
}

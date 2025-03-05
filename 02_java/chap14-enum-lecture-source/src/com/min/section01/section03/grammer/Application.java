package com.min.section01.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin.name());
        System.out.println(admin.getNameToLowerCase()); // 모든 필드에 들어갈 객체

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal() + ", " + consumer.name() + ", " + consumer.getDESCRIPTION());

        /* 설명 : Set 의 개념으로 활용할 수도 있다. (Iterator) */
        System.out.println("Set으로 바꿔 반복자를 활용해 보기");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().name());
        }
    }
}

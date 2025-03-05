package com.min.section4.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명
     *   기본 생성자(매개변수 없음)를 활용한 객체 생성
     *  기본 생성자는 지정해주지 않으면 자동으로 생긴다.
     *  하지만 명시적으로 써주는 것이 좋다. */
    public User() {
        System.out.println("기본 생성자 호출");
    }

    /* 설명
     *   원하는 필드를 초기화하기 위한 매개변수 있는 생성자를 활용해 객체를 생성할 수 있다. */
    public User(String id, String pwd, String name) {

        System.out.println("매개변수있는 생성자 호출");
        /* 설명
         *   생성자 안에서의 this. 은 이 생성자로 만들어질 객체에 접근하는 것이다. */
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        System.out.println("id = " + id + ", pwd = " + pwd + ", name = " + name);
    }

    public User(String id, String pwd, String name, Date enrollDate) {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
        /* 설명
         *   this()를 통해 다른 생성자를 호출하여 코드의 중복을 줄일 수 있다.
         *   this*()는 항상 첫 줄에 작성되어야 한다.
         *   2개 이상 적을 수 없다. */
        this(id, pwd, name);

        this.enrollDate = enrollDate;
    }

    public String information() {
        return "id: " + this.id + ", pwd: " + this.pwd + ", name: " + this.name
                + ", enrollDate: " + this.enrollDate;
    }
}

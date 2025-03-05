package com.min.section03.filterstream.dto;

import java.io.Serializable;

// Serializable : 객체의 내용을 직렬화 한다. 마커 인터페이스임. 객체 입출력을 할 타입의 클래스에 implements 해줘야함.
public class MemberDTO implements Serializable {
    private String id;

    /* 설명
     *   transient 키워드가 달린 필드는 객체 입출력 시 (직렬화 시 대상이 되지 않는다) 출력 되지 않는다. */
    private transient String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

package com.min.section02.encapsulation.resolved;

public class Monster {

    // 직접 접근을 막는다.
    // 정보 은닉 기술
    private String name;
    private int hp;

    public void setInfo(String info1) {
        this.name = info1;
    }

    public void setInfo2(int info2) {
        this.hp = info2;
    }
}

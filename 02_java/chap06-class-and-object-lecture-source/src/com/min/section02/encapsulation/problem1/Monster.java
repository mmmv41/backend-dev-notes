package com.min.section02.encapsulation.problem1;

public class Monster {
    // 속성이 될 것
    String name;
    int hp;

    public void setHp(int hp) {
        if (hp >= 0) {
            // 여기서 this. 는 monster2 객체를 가리킴 (내가 쓰인 곳을 가리킨다)
            // hp는 같은 메소드의 setHp를 가리킨다.
            this.hp = hp;
        } else {
            this.hp = 0;
        }
    }
}

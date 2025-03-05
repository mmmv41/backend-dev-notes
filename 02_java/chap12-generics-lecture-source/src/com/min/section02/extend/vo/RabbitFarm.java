package com.min.section02.extend.vo;

/* 설명
 *   RabbitFarm 제네릭 클래스
 *  T extends Rabbit 을 사용하여 T는 반드시 Rabbit 또는 Rabbit 하위 타입으로만 제네릭 타입을 지정할 수 있다.
 *  Rabbit이거나 Rabbit을 상속받은 클래스*/
public class RabbitFarm<T extends Rabbit> {
    private T rabbit;

    public RabbitFarm() {
    }

    public RabbitFarm(T rabbit) {
        this.rabbit = rabbit;
    }

    public T getRabbit() {
        return rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }
}

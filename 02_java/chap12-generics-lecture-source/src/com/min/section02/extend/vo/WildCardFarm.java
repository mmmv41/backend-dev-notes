package com.min.section02.extend.vo;

/* 설명
 *   이미 제네릭 객체가 있을 때 사용 */
public class WildCardFarm {

    /* 설명
     *   와일드 카드(wildcard)
     *   제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때 타입 변수를 제한할 수 있다.
     *   <?> : 제한 없음
     *   <? extends Type> : 와일드카드의 상한 제한(해당 Type과 Type의 후손을 이용해 생성된 제네릭 인스턴스만 가능
     *   <? super Type> : 와일드카드의 하한 제한(해당 Type과 Type의 부모를 이용해 생성된 제네릭 인스턴스만 가능)
     * */

    // 어떤 레빗팜이든 상관없다. 레빗만 객체가 될 수 있다. T extends Rabbit 의 조건을 만족해야함.
    /* 설명
     *   어떤 타입의 RabbitFarm (제네릭 타입) 이 와도 상관 없다. */
    public void anyType(RabbitFarm<?> farm) {
        farm.getRabbit().cry();
    }

    // 버니 또는 버니의 하위타입
    /* 설명
     *   RabbitFarm 중에서도 Bunny 또는 하위 타입이 있는 RabbitFarm 만 가능 */
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
    }

    // 버니또는 버니의 슈퍼 타입만 가능하다
    /* 설명
     *   RabbitFarm 중에서도 Bunny 또는 상위 타입이 있는 RabbitFarm 만 가능 */
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getRabbit().cry();
    }
}

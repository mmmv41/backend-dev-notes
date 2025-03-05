package com.min.section01.extend;

public class FireCar extends Car {

    public FireCar() {
        /* 설명 : 부모로부터 생성자는 물려받지 않고 super()를 통해 부모 객체 먼저 생성 */
        super();    // Car(부모 클래스)의 기본 생성자 호출
        System.out.println("FireCar 클래스의 기본 생성자 호출됨...");
    }

    /* 설명 : 부모로부터 물려받는 필드 및 메서드 외에 더 추가 */
    public void sparyWater() {
        System.out.println("불난 곳을 찾았습니다. 물을 뿌립니다 =============");
    }

    /* 설명
     *   @Override 어노테이션을 사용하는 이유?
     *   1. 메서드 중에 부모로부터 물려받아 재정의 하는 메서드를 파악하기 용이하도록 하기 위해 (가독성 측면)
     *   2. 부모의 메서드를 오버라이딩할 때 발생할 수 있는 실수를 방지하기 위해서(실수방지 측면) */
    @Override
    public void soundHorn() {
        System.out.println("빠아아아ㅏㅇㅇㅇㅇ₩₩₩₩₩₩₩₩₩");
    }

}

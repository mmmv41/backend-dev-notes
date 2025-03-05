package com.min.section02.extend.run;

import com.min.section02.extend.vo.Bunny;
import com.min.section02.extend.vo.DrunkenBunny;
import com.min.section02.extend.vo.Rabbit;
import com.min.section02.extend.vo.RabbitFarm;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   제네릭 클래스를 좀 더 활용하는 예제를 이해할 수 있다. */

        /* 설명
         *   컴파일 에러 발생. Rabbit 상위 타입은 제네릭 객체 생성 불가능 */
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<>();
//        RabbitFarm<Snake> farm3 = new RabbitFarm<>();

        // 객체가 생성되는 시점에 제한을 적으려면 제네릭 클래스에
        /* 설명
         *   <T extends Rabbit> 에 의해 Rabbit 및 하위 타입으로만 제네릭 객체 생성 가능 */
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();          // Rabbit/Bunny/DrunkenBunny 다 가능
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();           // Bunny만 가능
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();    // DrunkenBunny 만 가능

        farm4.setRabbit(new Rabbit());
        farm4.getRabbit().cry();
        farm5.setRabbit(new Bunny());
        farm5.getRabbit().cry();        // 동적 바인딩

//        farm5.setRabbit(new Rabbit);  // 컴파일 에러 발생
        farm5.setRabbit(new Bunny());
        farm5.getRabbit().cry();
    }
}

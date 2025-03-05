package com.min.section03.addtional;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)       // Order 어노테이션을 활성화 시킴.
public class AddtionalAnnotationTest {

    /* 수업목표 : Junit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */

    // 기능당 최소 3개의 테스트 케이스를 작성해야한다.
    @Disabled  // 재생 버튼이 사라진다.
    @Test
    public void testIgnore() {
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(900);      // Thread.sleep를 활용하면 밀리초 만큼 지연 가능
//        Thread.sleep(900);
    }

    /* memo : Order 어노테이션을 사용하려면 -> 클래스 위에 TestMethodOrder 어노테이션을 추가해야함.  */

    @Test
    @Order(1)
    public void testFirst() {

    }

    @Test
    @Order(3)
    public void testThird() {

    }

    @Test
    @Order(2)
    public void testSecond() {

    }


}

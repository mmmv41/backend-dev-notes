package com.min.section02.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleAnnotationTest {

    /* 수업목표 : 테스트 메소드의 실행 전 후에 동작하는 어노테이션을 사용할 수 있다. */

    /* 설명
     *   모든 테스트 메소드와 라이프사이클 관련 메소드는 abstract 이면 안됨, void 반환형(반환이 필요 x)으로 작성해야 한다.
     *   또한, 접근 제어자는 사용 가능하지만 (default), private 이면 안됨. */

    // 단위 테스트의 개수와 상관없이 한번만 동작한다.
    // static 을 반드시 사용해야함.
    /* 설명 : 테스트 실행되기 전에 한번만 실행 (static 으로 작성) */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    // static 사용 불가능
    /* 설명
     *   각각의 테스트 메소드가 실행되기 전에 주로 테스트 전에 필요한 목업 데이터를 미리 세팅해 줌
     *   실행에 필요한 가짜 데이터를 만든다. */
    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each");
    }


    // finally 와 같은 역할을 한다.
    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    /* 설명
     *   각각의 테스트 메소드가 동작한 이후 실행된다.
     *   주로 단위 테스트들이 수행된 이후 사용한 자원을 반납/해제할 목적으로 사용됨.*/
    @AfterEach
    public void afterEach() {
        System.out.println("After Each");
    }


    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}

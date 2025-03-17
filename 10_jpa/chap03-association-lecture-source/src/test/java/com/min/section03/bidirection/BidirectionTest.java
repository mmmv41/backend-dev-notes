package com.min.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BidirectionTest {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 설명 : 양방향 연관관계를 통해 만들 엔티티 개수는 줄어들지만 경우의 수를 모두 고려하여 설계해야 한다.
     *  */
    @Test
    public void 양방향_연관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        System.out.println("foundMenu = " + foundMenu);
    }
}

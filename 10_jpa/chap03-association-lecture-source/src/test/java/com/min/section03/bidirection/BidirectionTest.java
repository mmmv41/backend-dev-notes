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
     *  (특히 순환참조를 고여해야 한다. (toString() 작성 시 조심(join의 대상 제외) 해야 한다.)*/
    @Test
    public void 양방향_연관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        /* 설명 : 연관관계의 주인(자식 엔티티)은 한번에 left join 문으로 관계를 맺은 엔티티를 조회해 온다.  */
        Menu foundMenu = entityManager.find(Menu.class, menuCode); // ManyToOne
        System.out.println("foundMenu = " + foundMenu);
        System.out.println("10번 메뉴의 카테고리 : " + foundMenu.getCategory());// 객체 그래프 탐색

        /* 설명 : 양방향은 부모에 해당하는 엔티티는 가짜 연관관계이고 필요 시 연관관계 엔티티를 조회하는 쿼리로 작성한다.
         *       (FetchType.LAZY 처럼 동작) */
        Category foundCategory = entityManager.find(Category.class, categoryCode); // OneToMany
        System.out.println("foundCategory = " + foundCategory);
        System.out.println("10번 카테고리의 메뉴들 : " + foundCategory.getMenuList()); // menu 에 대한 select 발생
    }
}

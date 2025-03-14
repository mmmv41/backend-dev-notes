package com.min.section03.primarykey.subsection01.identity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimaryKeyMappingTest {
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

    @Test
    public void 식별자_매핑_테스트() {
        Member member1 = new Member();

        Member member2 = new Member();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member1);   // persist() : 비영속 상태를 영속 상태로 바꿔달라
        entityManager.persist(member2);

        transaction.commit();

        /* 설명 : persist 당시에는 부여되지 않은 pk 값으로 commit 이후 조회를 하면 가능할까? */
        Member selectedMember = entityManager.find(Member.class, 1);
        System.out.println("selectedMember = " + selectedMember);

        Assertions.assertEquals(1, selectedMember.getMemberNo());
    }
}

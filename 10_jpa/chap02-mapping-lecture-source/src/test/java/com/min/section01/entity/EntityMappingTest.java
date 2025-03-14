package com.min.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityMappingTest {
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

    // 모든 속성을 insert, update 한다. -> 적지 않은 속성은 null 로 표기된다.
    @Test
    public void 테이블_만들기_테스트() {

        // given
        Member member = new Member();
        member.setMemberNo(1);  /* memo : 직접 넣으려면 Member 클래스에 @GeneratedValue 를 작성하지 않아야 한다. */
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickName("밍경");
        member.setPhone("010-1234-5678");
        member.setEmail("min@gmail.com");

        // when
        EntityTransaction transaction = entityManager.getTransaction(); // manager 가 만든다.

        /* memo : 트랜잭션 시작 */
        transaction.begin();
        entityManager.persist(member);  // entity 객체를 맡아줘 -> persist

        // then
        Member foundMember = entityManager.find(Member.class, 1);
        // 위에서 맡아 달라한 1번을 달라 (select 으로 만들어지지 x, db에서 가져오는 것이 아니기 때문)
        foundMember.setNickName("유우시");

        transaction.commit();
        /* memo : 트랜잭션 종료 */
    }
}

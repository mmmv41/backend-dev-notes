package com.min.section01.manytoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// join 을 포함한 엔티티
@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")       // tbl_menu 는 자식 테이블
public class MenuAndCategory {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    // 조인을 고려하는 대상과의 관계를 기준으로 매핑
    @ManyToOne(fetch = FetchType.LAZY)      // 메뉴 : 카테고리 = N : 1 -> ManyToOne
    @JoinColumn(name = "category_code")     // FK 제약조건이 있는 컬렴명 (자식 테이블에 있는 컬럼명만 작성한다)
            Category category;  // 메뉴 1개가 카테고리 엔티티 객체를 몇개 가지는지 (List<타입>/타입)

    @Column(name = "orderable_status")
    private String orderableStatus;
}

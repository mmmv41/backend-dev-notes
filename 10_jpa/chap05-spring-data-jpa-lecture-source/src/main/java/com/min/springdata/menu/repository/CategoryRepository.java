package com.min.springdata.menu.repository;

import com.min.springdata.menu.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/* memo : JpaRepository<T, ID> - T : 엔티티 클래스, ID : 엔티티의 기본 키 타입
 *   - JpaRepository의 두 번째 제네릭 타입에는 원시 타입 int를 직접 사용할 수 없고, 대신 Integer(Wrapper Class)를 사용해야한다.
 *   - Category 클래스의 기본키 타입이 int 이기 때문에, Integer 로 작성  */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // JPQL 을 @Query 로 적기
    /* 설명 : findAll() 메소드 사용하는 대신, jpql 또는 native query 로 작성하기. */
//    @Query(value = "SELECT m FROM Category m ORDER BY m.categoryCode ASC")
    @Query(value = "SELECT CATEGORY_CODE, CATEGORY_NAME, REF_CATEGORY_CODE FROM TBL_CATEGORY"
                    + "ORDER BY CATEGORY_CODE ASC", nativeQuery = true)
    List<Category> findAllCategories();

}

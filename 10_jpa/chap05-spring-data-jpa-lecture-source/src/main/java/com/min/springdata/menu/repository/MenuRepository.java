package com.min.springdata.menu.repository;


import com.min.springdata.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/* memo : Spring Data JPA를 이용하여 Menu 엔티티를 관리하는 Repository 인터페이스 */
// 어떤 엔티티이고, pk 값은 어떤 값으로 구분되는지 적어줘야함.
//
/* memo :  인터페이스이기 때문에 객체가 될 수 없지만, JpaRespository 를 상속 받음으로써 bean 이 될 수 있다.*/
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}

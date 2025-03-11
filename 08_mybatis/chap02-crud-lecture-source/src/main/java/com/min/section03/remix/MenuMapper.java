package com.min.section03.remix;

import java.util.List;

/* memo : DAO + mapper */

/* 설명 :
 *   xml 방식(쿼리는 xml)과 java 방식(dao가 간단한 추상메소드)의 장점을 혼용하기 위한 방법
 *   1. xml 파일은 mapper 용 인터페이스와 같은 이름으로 되어야 한다. -> MenuMapper 와 resources/com/min/section03/remix/MenuMapper의 이름이 같아야 한다.
 *   2. xml 파일은 mapper 용 인터페이스와 같은 경로에 위치 되어야 한다.
 *   3. xml 파일은 namespace 는 mapper용 인터페이스로 작성해야 한다. (풀네임으로)
 *   4. xml 파일은 쿼리 id와 mapper용 인터페이스와 추상메소드가 일치되어야 한다.
 * */

/* memo :
 *   xml - 쿼리
 *   java - dao 를 간단한 인터페이스로 */
public interface MenuMapper {

    List<MenuDTO> selectAllMenus();

    MenuDTO selectMenu(int menuCode);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int menuCode);

}

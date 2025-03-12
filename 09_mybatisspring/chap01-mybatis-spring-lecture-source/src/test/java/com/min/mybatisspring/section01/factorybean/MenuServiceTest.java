package com.min.mybatisspring.section01.factorybean;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuServiceTest {
    /* memo : MenuService의 메소드를 테스트 하기 위해서는 객체가 필요한데, @Service로 bean 이 된 상태이기 때문에 사용 가능하다. */
    // MenuService 객체를 전달 받는다.
    @Autowired
    private MenuService menuService;

    @DisplayName("주문 가능 상태별 메뉴 조회 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Y", "N"})
    void testFindAllMenus(String orderableStatus) {

        // Service 계층(MenuService)의 메소드 한개를 여기서 지정한 값(Y, N)을 넣어서 테스트 진행
        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.findAllMenuByOrderableStatus(orderableStatus);
                    // orderableStatus 에 Y 또는 N 이 오게 된다.
                    menus.forEach(System.out::println);
                }
        );
    }
}
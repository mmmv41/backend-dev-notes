package com.min.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    // 이 트랜잭션 안에서 두개의 도메인을 건드린다.
    /* 설명 : Order 도메인과 Menu 도메인 두개를 하나의 Service 에서 트랜잭션 상 쓰는 경우를 설정 */
    private OrderMapper orderMapper;
    private MenuMapper menuMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper, MenuMapper menuMapper) {
        this.orderMapper = orderMapper;
        this.menuMapper = menuMapper;
    }

    /* memo : service 에 DML 작업 시 @Transactional 어노테이션을 붙이면 된다.  */
    // dml 작업이므로 commit, rollback 해야하는데, connection 객체가 내부적으로 할당됨 ->
    //  어노테이션을 만나면 메소드를 하나의 트랜잭션 단위로 본다. -> 메소드가 끝날 떄까지 문제 발생하지 않으면 commit은 자동으로 된다.
    // -> 문제가 발생하면 전부 rollback 된다.
    @Transactional
    public void registNewOrder(OrderDTO orderInfo) {
        /* 설명 : 1. 주문한 메뉴 코드 추출(DTO 에서) */

        /* 설명 : 2. 주문한 메뉴 별로 Menu 엔티티에 담아서 조회(select)해 오기(부가적인 메뉴의 정보 추출) */

        /* 설명 : 3. 이 주문건에 대한 주문 총 합계를 계산 */

        /* 설명 : 4. 1부터 3까지 하면 tbl_order 테이블에 추가(insert) */

        /* 설명 : 5. tbl_order_menu 테이블에도 주문한 메뉴 개수만큼 메뉴를 추가(insert) */

    }
}

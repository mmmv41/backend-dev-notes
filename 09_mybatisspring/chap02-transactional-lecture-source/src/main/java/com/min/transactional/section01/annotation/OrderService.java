package com.min.transactional.section01.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    /* memo : dml 작업이므로 commit, rollback 해야하는데, connection 객체가 내부적으로 할당됨
     *   어노테이션을 만나면 메소드를 하나의 트랜잭션 단위로 본다. -> 메소드가 끝날 떄까지 문제 발생하지 않으면 commit은 자동으로 된다.
     *   -> 문제가 발생하면 전부 rollback 된다.*/
    /* 설명. Service 계층의 메소드가 DML 작업용 트랜잭션이면 @Transactional을 추가한다. */
    @Transactional
    public void registNewOrder(OrderDTO orderInfo) { // 입력값이 주머니 형태로 담겨온다.

        /* 설명 : 1. 주문한 메뉴 코드 추출(DTO 에서) */
//        List<Integer> menuCode = new ArrayList<>();
//        List<OrderMenuDTO> orderMenus = orderInfo.getOrderMenus();
//        for (OrderMenuDTO orderMenu : orderMenus) {
//            menuCode.add(orderMenu.getMenuCode());
//        }
        List<Integer> menuCodes = orderInfo.getOrderMenus()
                .stream()
                .map(OrderMenuDTO::getMenuCode)
                .collect(Collectors.toList());

        // 사용자의 주문만 담음
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);   //  memo : menuCodes 를 한번에 키와 값 쌍으로 담는 작업

        // OrderDTO 에는 메뉴의 가격이 담겨오지 않기 때문에, Menu 엔티티의 조회가 필요하다. (menuPrice 의 정보 필요)
        /* 설명 : 2. 주문한 메뉴 별로 Menu 엔티티에 담아서 조회(select)해 오기(부가적인 메뉴의 정보 추출) */
        List<Menu> menus = menuMapper.selectMenuByMenuCodes(map);
//        menus.forEach(System.out::println);

        /* 설명 : 3. 이 주문건에 대한 주문 총 합계를 계산 */
        int totalOrderPrice = calcTotalPrice(orderInfo.getOrderMenus(), menus);

        /* 설명 : 4. 1부터 3까지 하면 tbl_order 테이블에 추가(insert) */

        /* 설명 : 4-1. OrderDTO -> Order */
        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice);

        /* 설명 : 4-2. Order로 insert (selectKey를 통해 insert 하고 나서의 주문번호를 orderCode에 담긴 상태로 돌아옴) */
        orderMapper.registOrder(order);
        System.out.println("tbl_order 테이블에 insert 후 Order 객체(Service 계층): " + order);

        /* 설명 : 5. tbl_order_menu 테이블에도 주문한 메뉴 개수만큼 메뉴를 추가(insert) */

        /* 설명 : 5-1. OrderDTO -> List<OrderMenuDTO> -> List<OrderMenu> */
        List<OrderMenuDTO> orderMenuDTO = orderInfo.getOrderMenus();
        for (OrderMenuDTO menuDTO : orderMenuDTO) {
            orderMapper.registOrderMenu(
                    new OrderMenu(order.getOrderCode(), menuDTO.getMenuCode(), menuDTO.getOrderAmount()));
        }
    }

    private int calcTotalPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {
        int totalPrice = 0;

        int orderMenuSize = orderMenus.size();
        for (int i = 0; i < orderMenuSize; i++) {            // 사용자가 주문한 메뉴 수만큼 반복
            OrderMenuDTO orderMenu = orderMenus.get(i);     // 메뉴 수량 추출을 위해
            Menu menu = menus.get(i);                       // 메뉴 단가 추출을 위해
            totalPrice += orderMenu.getOrderAmount() * menu.getMenuPrice();
        }

        return totalPrice;
    }
}

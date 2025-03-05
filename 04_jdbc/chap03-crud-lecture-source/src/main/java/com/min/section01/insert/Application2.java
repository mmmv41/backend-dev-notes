package com.min.section01.insert;

import java.util.Scanner;

/* memo : 실행 후
    select * from tbl_menu order by 1 desc; 로 확인 */


// service는 db를 모름. dao는 db와 친하다.  -> 수정이 일어나도 영향을 받지 않는다.
/* 설명 : Service 계층과 Repository(DAO(Data Access Object)) 계층을 구분하고 XML 파일에서 부터 쿼리를 불러와서
    insert 해보기 */
public class Application2 {
    /* 설명 : view 이자 controller 의 개념 (입력 받은 데이터로 하나의 Menu 객체로 만들기) */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴의 이름을 입력하세요: ");
        String menuName = sc.nextLine();
        System.out.println("메뉴의 가격을 입력하세요: ");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드를 입력하세요: ");
        int categoryCode = sc.nextInt();
        System.out.println("판매 상태를 입력하세요: ");
        sc.nextLine();  // 버퍼 제거
        String orderableStatus = sc.nextLine();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService service = new MenuService();
        service.registMenu(menu);
    }
}

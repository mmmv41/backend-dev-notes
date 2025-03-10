package com.min.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
    // MenuController 는 MenuService 를 호출한다.
    private final MenuService menuService;
    private final PrintResult printResult;
    //private final PrintResult printResult;

    // 생성자 주입 하는 방식으로
    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();
//        System.out.println("===== Controller에서 출력");
//        menuList.forEach(System.out::println);
        if (!menuList.isEmpty()) {       // 조회 성공
            printResult.printMenus(menuList);
        } else {                        // 조회 실패
            printResult.printErrorMessage("전체 메뉴 조회 실패!");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }
}

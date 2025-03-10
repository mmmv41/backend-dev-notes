package com.min.section01.xmlconfig;

import java.util.List;

public class PrintResult {
    public void printMenus(List<MenuDTO> menuList) {
        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String message) {
        System.out.println("에러 메시지 : " + message);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("조회 성공한 메뉴 = " + menu);
    }
}

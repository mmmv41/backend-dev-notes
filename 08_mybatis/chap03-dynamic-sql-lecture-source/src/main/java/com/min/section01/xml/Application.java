package com.min.section01.xml;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("===== 마이바티스 동적 SQL =====");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwises) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    ifSubMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        } while (true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService ms = new MenuService();
        do {
            System.out.println("===== if 서브 메뉴 =====");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호를 입력해 주세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    ms.findMenuByPrice(inputPrice());
                    break;
                case 2:
                    ms.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    return; // 자신을 호출한 main 메소드로 돌아간다.
            }
        } while (true);
    }

    private static Object inputSearchCriteria() {
        return null;
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 할 가격대의 최대 금액을 입력해 주세요 : ");
        return sc.nextInt();
    }
}

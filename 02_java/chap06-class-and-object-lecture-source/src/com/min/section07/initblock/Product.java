package com.min.section07.initblock;

public class Product {
    private String name = "이어폰";       //상품명
    private int price;                  //상품단가
    private static String brand;        //제조사

    /* 설명
     *   초기화 블럭은 생성자 이전에 실행되며 어떤 생성자로 객체를 생성하든 공통적인 로직이있다면 작성 */ {
        System.out.println("초기화 블럭 실행...");
        price = 170;
        brand = "삼성";
    }

    // static 초기화 블럭이 먼저 실행됨
    static {
//        price = 200;    // 인스턴스 변수는 접근 불가능
        brand = "엘지";
    }


    public Product() {
        System.out.println("Product 기본 생성자 호출 ...");
        name = "샤오미";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}

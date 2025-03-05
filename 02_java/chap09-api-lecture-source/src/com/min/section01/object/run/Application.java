package com.min.section01.object.run;

import com.min.section01.object.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 50000);
        BookDTO book2 = new BookDTO(2, "홍길동전", "허균", 50000);

        // 동일 비교(주소값이 값은지)
        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2));

        // 동등 비교(
        System.out.println("두 인스턴스를 equals() 메서드로 비교: " + (book1.equals(book2)));

        System.out.println("book1의 hashCode(): " + book1.hashCode());
        System.out.println("book2의 hashCode(): " + book2.hashCode());
    }
}

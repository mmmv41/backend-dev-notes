package com.min.section01.list.dto;

import java.util.Objects;

// Comparable 인터페이스를 구현하겠다.
public class BookDTO implements Comparable<BookDTO> {
    private int number;
    private String title;
    private String author;
    private int price;

    public BookDTO() {
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return price == bookDTO.price && Objects.equals(title, bookDTO.title) && Objects.equals(author,
                bookDTO.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    // 제네릭을 걸었기 떄문에 BookDTO라고 나온다.
    // 제네릭을 걸지않으면 Object o 라고 되기 떄문에 -> 다운 캐스팅 해줘야함 -> 번거롭기 때문에 제네릭을 사용한다.
    /* 설명
     *   new A().compareTo(new B())
     *   메서드를 호출한 변수.price와 BookDTO의 price를 비교
     *   매개변수의 BookDTO와 비교한다.
     *  한가지의 기준만 둘 수 있다. */
    /* 설명
     *   원하는 필드의 오름차순 또는 내림차순을 할 수 있다.
     *   필드가 n개면 총 (n * 2) 가지의 정렬 기준을 가질 수 있다 (각각 asc, desc)
     *   정렬은 compareTo() 메소드가 반환하는 int형의 부호에 따라 정해지게 되므로 오름차순과 내림차순을 부호만 달리 되도록 하면 된다.
     *   (해당 필드가 String형의 경우는 String에 정의 된 compareTo() 메소드를 활용한다.) */

    @Override
    public int compareTo(BookDTO o) {
//        /* 설명 : 가격에 대한 오름차순 */
//        return this.price - o.price;

        /* 설명 : 가격에 대한 내림차순 */
//         return o.price - this.price
//         return -(this.price - o.price);

        /* 설명 : 책 제목에 대한 오름차순 */
        return this.title.compareTo(o.title);

        // 컬렉션의 두 객체 비교
        // 낮은 값의 우선순위를 높여주는 알고리즘 (원래 낮은 값의 우선순위가 낮기 때문)
        // 두 개의 차이가 양수면 두 개의 순서를 뒤집음(음수는 뒤집지 않는다) -> 오름차순을 위한 알고리즘

    }
}

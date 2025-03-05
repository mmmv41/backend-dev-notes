package com.min.section01.list.run;

import com.min.section01.list.comparator.AscendingPrice;
import com.min.section01.list.dto.BookDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표
         *   ArrayList에서 관리되는 자료형의 정렬기준을 이용할 수 있다.*/
        List<BookDTO> bookList = new ArrayList<>();

        /* 설명
         *   BookDTO 객체(필드 4개)는 정렬의 기준이 8가지가 있다.*/
        /* 목차
         *   1. Comparable 인터페이스 구현 방법 */
        // 데이터의 클래스(BookDTO)에 가서 인터페이스를 구현 CompareTo를 오버라이드, 방법 8가지 중에 한가지만 구현 가능
        bookList.add(new BookDTO(1, "홍길동전", "허균", 90000));
        bookList.add(new BookDTO(2, "삼국유사", "허균", 60000));
        bookList.add(new BookDTO(3, "목민심서", "허균", 30000));
        bookList.add(new BookDTO(4, "동의보감", "허균", 20000));
        bookList.add(new BookDTO(5, "김", "허균", 70000));

        // AscendingPrice라는 새로운 기준을 사용해서 정렬.
        // 기존의 북리스트에 있던 ComapareTo 기준 말고 이 기준으로 실행된다.
        Collections.sort(bookList, new AscendingPrice());
        Collections.sort(bookList); //기본 정렬 기준을 사용해서 정렬

        /* 설명
         *   List 계열도 sort 메소드를 쓸 수 있는데, Comparator 를 구현한 클래스의 객체만 넘겨주면 된다.
         *  하위 구현체 객체의 주소값이 들어가야함 */
        //bookList.sort(new AscendingPrice());

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }
}

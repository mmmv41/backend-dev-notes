package com.min.section01.list.comparator;

import com.min.section01.list.dto.BookDTO;
import java.util.Comparator;

/* 설명 : BookDTO 에 대해 추가적인 정렬 기준(가격 오름차순)을 위한 클래스 */
public class AscendingPrice implements Comparator<BookDTO> {


    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        // private이므로 직접 접근 불가. getPrice()로 값 받아와야함.
        return -(o1.getPrice() - o2.getPrice());
    }

//    Comparator의 제네릭 타입을 작성하지 않는다면 추가 다운캐스팅을 해줘야함.
//    @Override
//    public int compare(Object o1, Object o2) {
//        // private이므로 직접 접근 불가. getPrice()로 값 받아와야함.
//        return ((BookDTO)o1).getPrice() - ((BookDTO)o1).getPrice();
//    }
}

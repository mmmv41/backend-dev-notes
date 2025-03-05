package com.min.section01.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/* memo : BookDAO 인터페이스를 구현하기 위한 클래스  */
@Repository
public class BookDAOImpl implements BookDAO {

    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1,
                new BookDTO(1, 123456, "자바의 정석",
                        "남궁성", "도우출판", new java.util.Date()));
        bookList.put(2,
                new BookDTO(2, 222334, "칭찬은 고래도 춤추게 한다.",
                        "고래", "고래출판", new java.util.Date()));
    }

    @Override
    public List<BookDTO> findAllBook() {
        /* 설명 : Map 을 list 형태로 변환 */
        return new ArrayList<>(bookList.values());  // map을 list 형식으로 바꾸는 방법
    }

    @Override
    public BookDTO findBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}

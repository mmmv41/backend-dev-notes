package com.min.section01.autowired.subsection01.field;

import com.min.section01.common.BookDAO;
import com.min.section01.common.BookDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 부가 기능은 없는 어노테이션. 가독성 측면이다.
public class BookService {

    // service 에 dao 빈을 넣는것이 핵심

    // 결과적으로 객체가 대입되어야함.
    // BookDAO 의 메소드가 호출된다.

    /* 설명 :
     *   1. 아래의 세 가지는 ComponentScan 범위 안에 어노테이션이 달렸을 때 유효하다.
     *   2. @Service 에 의해서 BookService 타입의 bookService id 의 bean이 관리된다.
     *   3. @Autowired 에 의해서 bookDAO 타입의 bean 이 BookService의 필드인 bookDAO 필드에 주입된다. (대입된다)
     *   = 필드 주입 */
    /* memo : 여기서 잠깐 멈추고, BookDAO를 본다. -> BookDAO는 인터페이스 이므로 -> BookDAOImpl 을 본다 ->  */
    @Autowired
    private BookDAO bookDAO;    // common 에 있는 BookDAO 를 의존하도록 설정

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    /* 설명 :  도서 번호로 도서 조회 */
    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }
}

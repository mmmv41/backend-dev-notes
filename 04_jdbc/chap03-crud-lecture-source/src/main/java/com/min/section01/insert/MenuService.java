package com.min.section01.insert;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.commit;
import static com.min.common.JDBCTemplate.getConnection;
import static com.min.common.JDBCTemplate.rollback;

import java.sql.Connection;

// commit 과 rollback 을 위해.
// 직접 db와 통신하지는 x
/* 설명 : Service 계층은 Connection 객체 생성 및 소멸(close) 및 비즈니스 로직, 트랜잭션 처리(commit/rollback) */
public class MenuService {
    public void registMenu(Menu menu) {
        /* 설명 : Connection 객체는 메소드 내부에서 생성하고 소멸한다. */
        Connection con = getConnection();
        /* memo : Connection 객체를 메소드 밖에 쓰지 않는 이유? */
        //  Connection 객체는 요청별로 할당 되어야하기 때문

        MenuRepository repository = new MenuRepository();
        int result = repository.insertMenu(con, menu);

        if (result == 1) {
            commit(con);    // 예외 처리 구문안에 없기 때문에, 예외 처리를 해주어야함.
        } else {
            rollback(con);
        }
        close(con);
    }

}

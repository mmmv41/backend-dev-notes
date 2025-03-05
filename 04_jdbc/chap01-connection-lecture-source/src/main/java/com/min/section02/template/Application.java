package com.min.section02.template;

/* 설명 : 다른 클래스의 static 메소드를 클래스명을 쓰지 않고 메소드만 호출 하기 위해서 import static을 한다.*/

import static com.min.section02.template.JDBCTemplate.close;
import static com.min.section02.template.JDBCTemplate.getConnection;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();

        /* 설명 : 비즈니스 로직 (트랜잭션 관련) 실행 */
        System.out.println("con = " + con);
        System.out.println("Conncetion 객체를 활용해 DB와 SQL로 소통");
        
        // close 라는 메소드를 생성하여 con를 넘겨주면 닫는다.
        close(con);
    }
}

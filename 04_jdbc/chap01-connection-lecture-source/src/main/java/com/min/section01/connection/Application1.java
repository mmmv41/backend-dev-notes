package com.min.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표 : 해당 DBMS 경로와 계정에 맞는 Conenction 객체를 생성할 수 있다. (해당 DBMS driver 라이브러리 필요) */
public class Application1 {
    public static void main(String[] args) {
        Connection con = null;

        /* memo : 예외가 발생하지 않으면, stream 이 만들어지면서 connection 객체가 생성된다.
            자바와 DB 가 연결하는 길 -> Connection 객체  */

        try {
            // static 영역에 만들어짐
            // 모든 dbms 드라이버마다 정해져있다.
            Class.forName("com.mysql.cj.jdbc.Driver");  // 누구
            // memo : localhost : db 서버가 떠있는곳의 위치, 3306 : 포트 번호
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", // 어디로. db가 어떤 경로로 갈지 지정
                    "root", "5133"); // 아이디, 비번을 통해 -> 인증을 받음

            System.out.println("Connection 객체: " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // stream 은 다 쓰면 닫아 줘야함.
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

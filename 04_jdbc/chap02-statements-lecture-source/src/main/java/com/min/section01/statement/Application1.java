package com.min.section01.statement;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application1 {
    public static void main(String[] args) {

        /* 설명 : Connection 객체 생성 */
        Connection con = getConnection();

        System.out.println("con = " + con);

        Statement stmt = null;
        /* memo :
         *   조회를 한다(select문)
         *  Statement에 쿼리를 싣고와서 나에게 와서 다시 준다.
         *  dml 작업은 반환형이 int (int 가 돌아오게 된다) */

        /* 설명 : 실행될 쿼리가 조회인 경우 */
        // select 하면 ResultSet 이 돌아온다.
        ResultSet rset = null;

        try {
            stmt = con.createStatement(); // 트럭이 만들어진다.

            /* 설명 : 여기서는 다중행 */
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE"); // 여기서 select

            while (rset.next()) {
                // 테이블의 자료형에 따라 getString(), getInt() 등을 골라야 한다.
                /* 설명 : 반복문 안에서의 rset 은 단일행으로 해석한다. */
                System.out.println(rset.getString("EMP_NAME") + ", "
                        + rset.getString("SALARY") + ", ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            /* memo : JDBCTemplate에 Connection close() 메소드를 만든 것처럼, stmt 와 rset 도 만들어준다. */
            close(rset);
            close(stmt);
            close(con);
            /* memo : 만들어진 순서의 반대로 닫아줘야한다.
             *   con -> stmt -> rset 순으로 만들어줬으니 rset -> stmt -> con 순으로 닫아주기 */

        }

    }
}

package com.min.section02.prepared;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();

        // 속도가 더 빠르다
        /* 설명 : Statement 보다 캐싱을 활용해 실행 속도가 더 빠르다 (최초 한번 이후부터 Statement 보다 빠르다.)*/
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            /* 설명 : Statement 와 달리 PreparedStatement 는 생성 당시에 쿼리가 있어야 함. */
            pstmt = con.prepareStatement("SELECT EMP_ID FROM EMPLOYEE"); // 쿼리를 미리 만들어야 실행 가능
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                        + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}

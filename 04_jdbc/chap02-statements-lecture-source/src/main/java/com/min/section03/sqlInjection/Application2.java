package com.min.section03.sqlInjection;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application2 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 설명
         *   아래 sql 과 같이 PreparedStatement 는 placeholder 로 입력되는 값에 single quotation(')이 있다면
         *   single quotation 을 하나 더 이어 붙여주고 양 옆에도 ' 를 붙여준다.
         *   이를 통해 SQLInjection 공격을 막게 된다. */

//        select * from employee where emp_id= 200 and emp_name = ''' or 1=1 and mep_id = ''200'

        try {
            pstmt = con.prepareStatement("select * from employee where emp_id = ? and emp_name = ?");
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("emp_name") + "님 환영합니다.");
            } else {
                System.out.println("해당 회원은 존재하지 않습니다.");
                /* memo : 이게 뜨면 sqlInjection 공격을 막았다는 뜻 */

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

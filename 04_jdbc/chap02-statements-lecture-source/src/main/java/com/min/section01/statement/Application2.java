package com.min.section01.statement;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* memo : 요청 1건당 Connection 객체가 생성
            (Connection 은 요청을 처리하기 위해 어떤 연결을 처리해야 하는지 알기 때문에, 그 길이 할당 된다.) */
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명 : 사용자로부터 사번을 입력 받아 사원 조회 */
            Scanner sc = new Scanner(System.in);
            System.out.println("사번 입력 : ");
            int empId = sc.nextInt();

            String query = "select * from employee where emp_id = '" + empId + "'";
            rset = stmt.executeQuery(query);

            /* memo : 서비스 계층이 하는 일 (출력 x, 처리해줌) */

            if (rset.next()) {
                System.out.println("조회하신 " + empId + "번 사원은 "
                        + rset.getString("emp_name") + "입니다. ");
            } else {
                System.out.println("해당 사원은 존재하지 않습니다. ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}

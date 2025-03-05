package com.min.section02.prepared;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* memo : ? 는 사용자에게 입력을 받는다.
         *   placeholder : 통으로 해석해서 기억해놓을 수 있다.  */

        Scanner sc = new Scanner(System.in);
        System.out.println("사번을 입력하세요 : ");
        String empId = sc.next();

        System.out.println("퇴사 여부를 입력하세요(Y/N): ");
        String entYn = sc.next();

        try {
            /* memo : PreparedStatement 는 Statement 와 달리 placeholder(?) 를 활용해 하나의 문자열 형태로 작성 가능하다.
             *   ? 이 두개이므로, 두개를 입력 받아야 함.*/
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?");
            // 사번, 퇴사여부를 입력 받아 그 조건에 맞는 사번, 이름이 출력된다.

            pstmt.setString(1, empId);  // 넣는 자료형이 String 이기 때문에 -> setString
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                System.out.println("조회하신 사원의 사번과 이름은 " + rset.getString("EMP_ID")
                        + "번의 " + rset.getString("EMP_NAME") + "입니다.");
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

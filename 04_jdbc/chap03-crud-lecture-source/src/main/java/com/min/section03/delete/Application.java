package com.min.section03.delete;

import static com.min.common.JDBCTemplate.close;
import static com.min.common.JDBCTemplate.commit;
import static com.min.common.JDBCTemplate.getConnection;
import static com.min.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result = 0;

        /* 설명. 1. soft delete */
//        String query = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE = ?";

        /* 설명. 2. hard delete */
        String query = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 4);

            result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("update 성공");
                commit(con);
            } else {
                System.out.println("update 실패");
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
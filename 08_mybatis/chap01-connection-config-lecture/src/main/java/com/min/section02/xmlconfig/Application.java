package com.min.section02.xmlconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);

            Date date = session.selectOne("mapper.selectNow");
            System.out.println("date1 = " + date);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}

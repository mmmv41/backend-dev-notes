package com.min.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String password = "5133";

    public static void main(String[] args) {

        /* 설명 :
         *  JdbcTransactionFactory : 수동 커밋
         *  ManagedTransactionFactory : 자동 커밋
         *  ==================================
         *  PooledDataSource : ConnectionPool 사용
         *  UnPooledDataSource : ConnectionPool 미사용
         * */
        Environment environment = new Environment(  // 환경 설정
                "dev",
                new JdbcTransactionFactory(),   // 수동 커밋을 하겠다.
                new PooledDataSource(driver, url, user, password)
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);  // Mapper 는 내가 만든 인터페이스이다.

        /* 설명 :
         *   SqlSessionFactory : SQLSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         *   SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
         *   build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java 방식) 혹은 외부 설정 파일과 연관된 stream 을
         *             매개변수로 전달(xml 방식) 하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 직접 판단해서 커밋을 해야하기 때문에 -> false 로 둔다 (수동 커밋을 한다)
        SqlSession session = sqlSessionFactory.openSession(false);   // Connection 객체. false를 넣어야 완벽하게 수동 커밋이된다.

        Mapper mapper = session.getMapper(Mapper.class);

        java.util.Date date = new java.util.Date();
        System.out.println("date = " + date);

        session.close();    // Connection 객체는 다 쓰고 자원을 반납해야한다.

    }
}

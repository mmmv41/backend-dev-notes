package com.min.section01.xml;

import static com.min.section01.xml.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = // mapper 를 가지고 있는 쿼리의 입장으로 본다.
                sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenu(Object o) {
    }
}

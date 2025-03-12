package com.min.section01.xmlmapper;

import static com.min.section01.xmlmapper.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class ElementService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menus = mapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);

        System.out.println("첫 번째 메뉴의 카테고리 이름 : " + menus.get(0).getCategory().getCategoryName());

        sqlSession.close();
    }


}

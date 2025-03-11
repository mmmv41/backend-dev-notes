package com.min.section01.xml;

import static com.min.section01.xml.Template.getSqlSession;

import java.util.List;
import java.util.Map;
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

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = // mapper 를 가지고 있는 쿼리의 입장으로 본다.
                sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(randomList);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByNameOrCategory(criteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        int result = mapper.updateMenu(criteria);

        if (result == 1) {
            System.out.println("메뉴 정보 변경에 성공하였습니다.");
            sqlsession.commit();
        } else {
            System.out.println("메뉴 정보 변경에 실패하였습니다.");
            sqlsession.rollback();
        }
        sqlsession.close();
    }
}

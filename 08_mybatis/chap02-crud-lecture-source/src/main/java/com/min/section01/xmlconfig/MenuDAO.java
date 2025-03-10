package com.min.section01.xmlconfig;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenus");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }


}

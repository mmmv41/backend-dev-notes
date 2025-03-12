package com.min.mybatisspring.section01.factorybean;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SqlSessionTemplate 에서 부터 의존성을 받을 수 있다.
@Service
public class MenuService {
    /* 설명 : 커넥션 객체의 개념인 SqlSessionTemplate */
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /* 설명 : 메뉴의 활성화 상태("Y"/"N")에 따른 메뉴 조회 */
    public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus) {
        return sqlSession.getMapper(MenuMapper.class).selectAllMenuByOrderableStatus(orderableStatus);
    }
}

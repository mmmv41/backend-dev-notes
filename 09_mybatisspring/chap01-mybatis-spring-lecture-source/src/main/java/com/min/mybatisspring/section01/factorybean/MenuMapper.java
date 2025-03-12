package com.min.mybatisspring.section01.factorybean;

import java.util.List;

public interface MenuMapper {
    /* memo : WHERE A.ORDERABLE_STATUS = #{test} 라고 했으니 test 라고 이름 맞춰주기 */
    List<MenuDTO> selectAllMenuByOrderableStatus(String test);
}

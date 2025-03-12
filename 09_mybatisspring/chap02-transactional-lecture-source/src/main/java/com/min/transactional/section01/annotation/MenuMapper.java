package com.min.transactional.section01.annotation;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    List<Menu> selectMenuByMenuCodes(Map<String, List<Integer>> map);
}

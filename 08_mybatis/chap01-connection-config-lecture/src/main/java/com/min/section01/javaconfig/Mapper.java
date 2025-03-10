package com.min.section01.javaconfig;

import java.util.Date;
import org.apache.ibatis.annotations.Select;

public interface Mapper {
    /* memo : 이 쿼리의 이름은 메소드 이름이 된다.
     *   쿼리와 메소드를 매핑.  */
    @Select("SELECT NOW()")
    Date selectNow();

}

package com.min.transactional.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/* memo : @ComponentScan 과 비슷하다 */
@MapperScan(basePackages = "com.min.transactional", annotationClass = Mapper.class)
public class MybatisConfiguration {
}

package com.min.springdata.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // bean 으로 등록해서 의존성 주입받아 사용한다.
    /* 설명 : DTO -> Entity, Entity -> DTO  매핑을 위한 modelmapper 라이브러리 bean 추가 */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

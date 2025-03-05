package com.min.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
/* memo : bean을 아래의 설정들을 이용해 만든다. */
public class ContextConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        /* 설명 : 접속하는 세션의 로케일(Locale) 에 따라 자동 재로딩하는 용도의 MessageSource 구현체 */
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();

        /* memo : 아래의 3가지는 기본적으로 설정한다.  */
        /* 설명 : 다국어 메시지를 읽어올 설정 파일(properties) 의 이름과 경로를 설정한다.  */
        messageSource.setBasename("section03/properties/subsection02/i18n/message");   // 리소스의 경로 작성
        // 경로에 파일이 있으면 다국어 메시지를 읽어올 것임.

        /* 설명 : 불러온 메시지를 설정한 해당 시간동안 캐싱한다. */
        messageSource.setCacheSeconds(10);  // 10초 동안 캐싱

        /* 설명 : 기본 인코딩 셋을 설정. */
        messageSource.setDefaultEncoding("UTF-8");  // 한글을 사용하기 때문에 UTF-8 로 인코딩.

        return messageSource;
    }
}

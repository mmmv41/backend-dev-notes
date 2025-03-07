package com.min.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 정적 리소스의 위치를 호출할 때 ?
/* memo : WebMvcConfigurer 라는 설정을 만들고 빈으로 만든 애를(StopwatchInterceptor)
    의존성 주입 받아(여기서는 생성자 주입) 인터셉터로 등록 */

/* 설명 : Interceptor 추가 및 static(정적) 리소스 호출 경로 등록 설정 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private StopwatchInterceptor stopwatchInterceptor;

    @Autowired
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)  // Interceptor 로 등록
                .excludePathPatterns("/css/**");
    }

    /* 설명 : 웹 서버에 대한 설정. servlet 등이 필요없다.
    *   보통 WebMvcConfigurer 은 정적 리소스 등록으로 많이 사용된다. */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/") // classpath 는 resources 라고 스프링이 인지한다.
                .setCachePeriod(100);
    }
}

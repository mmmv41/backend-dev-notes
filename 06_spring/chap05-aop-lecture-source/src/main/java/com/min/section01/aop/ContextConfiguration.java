package com.min.section01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.min.section01.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 이게 있어야 Aspect의 어노테이션이 적용 가능 -> auto proxy 가능
public class ContextConfiguration {
}

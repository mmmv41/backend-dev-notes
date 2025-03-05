package com.min.section03.annotationconfig.subsection01.java;

import com.min.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* 설명 : section03 에서는 ComponentScan 과 관련하여 java 클래스에서 @ComponentScan 범위를 bean 으로 등록하는 방법을 다룸.
 *   (실제 bean으로 등록할 떄 자주 쓰는 어노테이션) */
@Configuration
/* 설명 : 1. 기본적으로는 설정 파일이 있는 패키지 및 하위만 Scan 하지만 basePackages를 바꾸면 다른 범위까지 가능  */
//@ComponentScan(basePackages = "com.min") // 다른 범위도 스캔하도록 넓혀주는 어노테이션 (컴포넌트 계열을 찾는다)

/* 설명 : 2. 범위 및 필터를 적용해서 제외하고자 하는 bean 을 등록하는 경우 (excludeFilters. 블랙 리스트 방식) */
//@ComponentScan(basePackages = "com.min",
//        excludeFilters = {
//                // 이 범위 안의 타입은 빈으로 만들지 않는다.
//                @ComponentScan.Filter(
//                        /* 설명 : 2-1. 타입으로 설정 */
////                type = FilterType.ASSIGNABLE_TYPE,
////                classes = {MemberDAO.class} // @Component 중에서 MemberDAO 뺴고 만든다.
//
//                        /* 설명 : 2-2. 어노테이션의 종류로 설정 */
//                        type = FilterType.ANNOTATION,
//                        classes = {org.springframework.stereotype.Repository.class}
//                )
//        })
// s 가 붙은 애들 -> {} 쓰고 원하는 경로 다 적기 (스캔 범위 넓게 가능)

/* 설명 : 3. 범위 및 필터를 적용해서 등록하고자 하는 bean 을 등록하는 경우(includeFilters) */
@ComponentScan(basePackages = {"com.min", "com"},  // 중괄호 열고 경로 여러개 지정 가능
        useDefaultFilters = false,      // 현재 설정 파일 bean 제외 나머지는 off
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {MemberDAO.class}     // MemberDAO 타입 bean 만 등록
                )
        })

public class ContextConfiguration {
}

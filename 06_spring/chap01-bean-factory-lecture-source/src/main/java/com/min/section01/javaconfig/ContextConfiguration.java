package com.min.section01.javaconfig;

import com.min.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 메소드 이름이 빈 이름이다.
// 하나의 컨테이너에 같은 이름의 빈이 올수 x
// 어노테이션이 붙으면 빈이 되어서 컨테이너가 관리해준다.
@Configuration("config1")
public class ContextConfiguration {

    @Bean("member") // 콩의 고유 이름. 이름을 지정할 수 있다.
    public MemberDTO getMember() {
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }
}

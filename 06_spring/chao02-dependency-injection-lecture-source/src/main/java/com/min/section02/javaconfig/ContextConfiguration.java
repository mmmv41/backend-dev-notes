package com.min.section02.javaconfig;

import com.min.common.Account;
import com.min.common.MemberDTO;
import com.min.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    /* memo : 두 빈 다 컨테이너 안에 있다.
     *   컨테이너 안에서 빈을 꺼내는 방법 3가지가 있었는데,
     *   콩 이름 : accountGenerator, memberGenerator 두가지이다.  */
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-4567890");
    }

    @Bean
    public MemberDTO memberGenerator() {

        /* 설명 : setter 벙삭으로 주입하는 방법 */
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setSequence(1);
        memberDTO.setName("홍길동");
        memberDTO.setPhone("hong@gmail.com");
        memberDTO.setPersonalAccount(accountGenerator());

        return memberDTO;

        /* 설명 : 생성자 주입 */
//        return new MemberDTO(1, "홍길동","010-2344-3434",
//                "hong@gmail.com",accountGenerator());
    }
}

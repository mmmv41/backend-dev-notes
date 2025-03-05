package com.min.section01.aop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* memo : service 계층은 항상 repository 계층을 의존한다. */
@Service
public class MemberService {
    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<MemberDTO> findAllMembers() {
        System.out.println("target -> findAllMembers 실행");
        return memberDAO.selectAllMembers();
    }

    public MemberDTO findMemberBy(int index) {
        System.out.println("target -> findMemberBy 실행");
        return memberDAO.selectMemberBy(index);
    }
}

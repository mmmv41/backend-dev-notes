package com.min.section08.uses;

import java.util.Arrays;

public class MemberService {
    /* 설명
     *   회원 가입을 5명 진행(저장)하기 위해 회원 가입용 객체의 메서드를 호출(전달인자를 전달하며) */
    public void signUpMembers() {
        Member[] members = new Member[5];
        members[0] = new Member(1, "user01", "pass01", "1번", 20, 'M');
        members[1] = new Member(2, "user02", "pass02", "2번", 20, 'M');
        members[2] = new Member(3, "user03", "pass03", "3번", 20, 'M');
        members[3] = new Member(4, "user04", "pass04", "4번", 20, 'M');
        members[4] = new Member(5, "user05", "pass05", "5번", 20, 'M');

        MemberRegister register = new MemberRegister();
        register.regist(members);
    }

    public void showAllMembers() {
        MemberFinder finder = new MemberFinder();
        System.out.println("===== 가입된 회원 목록 =====");
        System.out.println(Arrays.toString(finder.findAllMembers()));
        Member[] returnMembers = finder.findAllMembers();
        for (Member m : returnMembers) {
            System.out.println(m);
        }
    }
}
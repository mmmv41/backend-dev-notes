package com.min.section04.testapp.service;

import com.min.section04.testapp.aggregate.AccountStatus;
import com.min.section04.testapp.aggregate.Member;
import com.min.section04.testapp.repository.MemberRepository;
import java.util.ArrayList;

// 서비스 계층용 클래스 (비즈니스 로직 처리를 담당함)
/* 설명 : 트랜잭션 처리 (성공 실패에 따라 commit/rollback) 및 회원 관리 비즈니스 로직 처리
 *   데이터와 상호작용은 repository가 하기 때문에 service에서 요청 해야함.*/
public class MemberService {

    // 멤버 서비스로 옴.
    // MemberRepository 먼저 정의 내려져야함. 다시 이동
    private final MemberRepository mr = new MemberRepository();

    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();

        System.out.println("Service에서 조회 확인: ");
        for (Member member : findMembers) {
            System.out.println(member);
        }
    }

    public void findMemberBy(int memNo) {
        Member findMember = mr.selectMemberBy(memNo);

        if (findMember != null) {
            System.out.println("회원 조회 성공: " + findMember);
        } else {
            System.out.println(memNo + "빈 회원은 없습니다.");
        }
    }

    /* memo : 회원가입에서 입력받은 값 들어옴  */
    public void registMember(Member member) {
        /* 설명 : 회원가입 시 입력받은 값 제외 두개를 마저 채워준다. */
        /* 설명 1. 회원 번호 추가 */
        // 데이터는 repository가 가지고있다. -> 메소드로 상호작용한다.
        int lastMemberNo = mr.selectLastMember();
        member.setMemNo((lastMemberNo + 1));    // ??

        /* 설명 2. 회원 활성화 상태 추가 */
        member.setAccountStatus(AccountStatus.ACTIVE);

        /* 설명 : 모든 DML 작업(Insert/Update/Delete)이 일어난 행(객체)의 개수 */
        int result = mr.insertMember(member);
        System.out.println("insert 성공실패 여부: " + result);

        if (result == 1) {
            System.out.println("회원가입을 축하드립니다 ! " + member.getId() + "님~");
        } else {
            System.out.println("회원가입에 실패하였습니다. ");
        }
    }

    public Member findMemberForMod(int memNo) {
        Member selectedMember = mr.selectMemberBy(memNo);

        if (selectedMember != null) {   // 해당 회원이 조회 되었을 때
            // 원본의 정보로 사본을 만듦
            /* 설명 : 조회된 회원을 그대로 반환해서 수정하면 Repository 의 컬렉션에 담긴 객체가 수정된다. */
            /* 설명 : 따라서 우리는 사본의 개념을 만들어 Repository의 컬렉션이 오염되지 않도록 할 것이다.
             *   원본에 변경사항을 주지 않고, 사본을 이용 */
            Member newInstance = new Member();
            newInstance.setMemNo(selectedMember.getMemNo());
            newInstance.setId(selectedMember.getId());
            newInstance.setId(selectedMember.getPwd());
            newInstance.setAge(selectedMember.getAge());

            /* 설명 : 취미는 배열이고, 배열은 깊은 보갓를 해 주어야 사본인 회원이 따로 취미 배열을 가지게 된다. */
            String[] copiedHobbies = selectedMember.getHoobies().clone();   // 깊은 복사
            newInstance.setHoobies(selectedMember.getHoobies());
            newInstance.setBloodType(selectedMember.getBloodType());
            newInstance.setAccountStatus(selectedMember.getAccountStatus());

            System.out.println("조회된 회원(의 사본)은 : " + newInstance);
            return newInstance;
        } else {
            System.out.println("그런 회원은 없네요. ");
        }
        return selectedMember;
    }

    public void modifyMember(Member reformedMember) {
        int result = mr.updateMember(reformedMember);

        if (result == 1) {
            System.out.println("회원님의 정보를 수정했습니다. ");
        } else {
            System.out.println("회원정보 수정 실패 ");
        }
    }

    public void removeMember(int removeMemNo) {
        int result = mr.deleteNumber(removeMemNo);   // MemNo가 3인 회원을 delete
        if (result == 1) {
            System.out.println(removeMemNo + "번 회원 탈퇴를 성공하였습니다. ");
        } else {
            System.out.println("회원 탈퇴를 실패하였습니다. ");
        }
    }
}

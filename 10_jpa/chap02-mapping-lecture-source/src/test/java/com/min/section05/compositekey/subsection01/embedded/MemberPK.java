package com.min.section05.compositekey.subsection01.embedded;

import jakarta.persistence.Embeddable;
import java.util.Objects;

/* 설명 :
    Embeddable 타입은 하나의 값의 묶음이자 불변 객체로 다루는 타입이다.
    (불변 객체 : setter 가 없고, 필드 값에 변화가 생기면 새로운 객체를 생성해야 하는 객체
    그리고 (equals/hashCode)를 오버라이딩 해야 한다. (동등해도 같다고 하기 위한 설정)
    VO 와 유사하며 @EmbeddedId 로 복합키를 표현하고자 할 때 쓰기도 한다. */

// @Embeddable 은 @EmbeddedId 로 정의 되어야 한다.
/* memo : Member의 복합키는 MemberPK다 라고 정의해줘야함. */
@Embeddable // 값을 담기위한 불변 객체 (두개를 묶어 하나로 보자 -> 하나의 값으로 비교)
public class MemberPK { // VO class 라고 정의해도 된다.
    private int memberNo;
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }
}

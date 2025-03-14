package com.min.section03.primarykey.subsection02.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity(name = "member_section03_subsection02")
@Table(name = "tbl_member_section03_subsection02")
public class Member {

    /* 설명 :
     *   IDENTITY : MySQL 또는 MariaDB 의 auto_increment
     *   SEQUENCE : 데이터베이스의 시퀀스 객체 사용(Oracle의 SEQUENCE)
     *   TABLE : 키 생성 테이블 사용
     *   AUTO : 자동 선택(MySQL 이면 IDENTITY / Oracle 이면 SEQUENCE) */
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;   // pk 이기 때문에 not null 조건이 걸려있다.

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "nickname")
    private String nickName;

    // 없는 DB 를 생성할 때 쓰는 속성 (이걸로 테이블을 만들 때 속성을 써주는 편이다, 보통 DB 모델링에서 써주고 여기서는 쓰지 않는다.)
    @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-1234'")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "enroll_date")
    @Temporal(TemporalType.TIMESTAMP)       // Datetime
    private Date enrollDate;

    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickName, String phone, String email,
                  String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
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

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

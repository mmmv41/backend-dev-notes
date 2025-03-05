package com.min.section04.testapp.repository;

import com.min.section04.testapp.aggregate.AccountStatus;
import com.min.section04.testapp.aggregate.BloodType;
import com.min.section04.testapp.aggregate.Member;
import com.min.section04.testapp.stream.MyObjectOutput;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/* 설명 : 데이터베이스 개념(Member 관련 파일)과 입출력(CRUD) 을 위해 만들어지며 성공데이터 또는 성공/실패 여부를 반환
 *   자바의 컬렉션 개념으로 데이터를 관리 */
public class MemberRepository {

    /* memo : 처음부터 객체를 생성 -> nullPointerException 발생하지 않는다.  */
    private final ArrayList<Member> memberList = new ArrayList<>();

    /* memo : DB와의 연결 정보  */
    private final File file = new File("src/main/java/com/min/section04/testapp/db/memberDB.dat");


    // 객체가 생성되는 시점 -> 프로그램 실행하자마자
    // 파일이 없으면 실행, 있으면 절대 실행되지 않는다.
    /* 설명 : 프로그램 구동시 MemberRepository 생성자가 호출되며 초기에 실행할 내용들
     *   static 먼저 인지 -> final 때문에 처음에 값이 필요함(나중에 값 넣을수 없음) -> 스태틱 영역의 공간이 생길 때, new MemberService()가 실행되어 주소가 생겨야함  */
    public MemberRepository() {
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(
                    new Member(1, "user01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMembers.add(
                    new Member(2, "user02", "pass02", 10, new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMembers.add(
                    new Member(3, "user03", "pass03", 20, new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));

            saveMembers(defaultMembers);
        }

        loadMembers();
    }

    /* 설명 : 파일로부터 회원 객체들을 읽어와서 memberList 컬렉션에 저장 */
    private void loadMembers() {
        try (ObjectInput ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // MemberRepository 생성자에서만 ?? 책임을 지게끔 코드를 작성 -> 단일 책임의 원칙
    /* 설명 : ArrayList<Member> 를 받으면 파일로 출력하는 메소드 (덮어씌우는 기능)*/
    private void saveMembers(ArrayList<Member> inputMembers) {
        ObjectOutput oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));

            // 파일이 없을 때만 일어난다,
            for (Member member : inputMembers) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명 : 초기에 Member 파일이 없다면 파일을 만들어 더미데이터(dummy data)를 쌓는다 */
    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMemberBy(int memNo) {
        Member returnMember = null;

        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                returnMember = member;  // returnMember는 처음엔 null이였지만, if문에서 일치하면 member를 넣어서 반환
            }
        }
        return returnMember;
    }

    public int selectLastMember() {
        Member lastMember = memberList.get(memberList.size() - 1);  // 마지막 멤버의 인덱스
        return lastMember.getMemNo();
    }

    public int insertMember(Member member) {

        /* 설명 : 헤더가 추가되지 않는 ObjectOutputStream 클래스 정의(MyObjectOutputStream) */
        MyObjectOutput moo = null;
        int result = 0;

        try {
            // true를 넣어야 이어 붙이기가 된다
            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            /* 설명 : 파일로 신규회원 추가하기 */
            moo.writeObject(member);   /* memo : insert 역할 */

            /* 설명 : 컬렉션에도 신규회원 추가하기
             *    MyObjectOutputStream 으로 이어붙인 정보는 다시 입력받아도 미전 파일로 인식함
             *   프로그램을 껐다 키면 다시 재인식이 되긴 한다. */
            memberList.add(member);

            result = 1;


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) {
                    moo.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    /* 설명 : 수정된 사본이 넘어오면 컬렉션에 담긴 동일한 회원을 update하고 컬렉션의 회원 정보로 파일을 덮어씌운다. */
    public int updateMember(Member reformedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemNo() == reformedMember.getMemNo()) {
                memberList.set(i, reformedMember);  // 컬렉션 업데이트
                saveMembers(memberList);            // 파일 업데이트(덮어씌우기)

                return 1;
            }
        }
        return 0;
    }

    public int deleteNumber(int removeMemNo) {
        int result = 0;

        for (Member mem : memberList) {
            if (mem.getMemNo() == removeMemNo) {
                mem.setAccountStatus(AccountStatus.DEACTIVATED);
                result = 1;
                saveMembers(memberList);
            }
        }
        return result;
    }
}

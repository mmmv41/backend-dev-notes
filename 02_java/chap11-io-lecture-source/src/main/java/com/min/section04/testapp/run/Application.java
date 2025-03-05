package com.min.section04.testapp.run;

import com.min.section04.testapp.aggregate.BloodType;
import com.min.section04.testapp.aggregate.Member;
import com.min.section04.testapp.service.MemberService;
import java.util.Scanner;

// run, view의 역할
public class Application {

    /* memo : final -> 요청을 처리해주는 객체를 하나로 고정하겠다.
     *   실행시마다 객체 생성되는걸 막기 위함. */

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== 화면 관리 프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기 ");
            System.out.println("2. 회원 찾기 ");
            System.out.println("3. 회원 가입 ");
            System.out.println("4. 회원 정보 수정 ");
            System.out.println("5. 회원 탈퇴 ");
            System.out.println("9. 프로그램 종료 ");
            System.out.println("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ms.findAllMembers();
                    break;
                case 2:
                    ms.findMemberBy(chooseMemNo());
                    break;
                case 3: // 2.12 여기부터 시작 / 회원가입 버튼 누르면 signUp()으로
                    ms.registMember(signUp());
                    break;
                case 4:
                    // 수정할 대상부터 찾기
                    Member selected = ms.findMemberForMod(chooseMemNo());
                    if (selected == null) {
                        continue;
                    }
                    ms.modifyMember(reform(selected));
                    break;
                case 5:
                    ms.removeMember(chooseMemNo());
                    break;
                case 9:
                    System.out.println("회원관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println(
                            "번호를 잘못 입력하셨습니다.");
            }
        }

    }

    private static Member reform(Member modifyMember) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==== 회원 정보 수정 서브 메뉴 ====");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("9. 메인 메뉴로 돌아가기");
            int chooseNo = sc.nextInt();
            sc.nextLine(); // 버퍼 엔터 제거용
            switch (chooseNo) {
                case 1:
                    System.out.println("수정 할 패스워드를 입력하세요: ");
                    modifyMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.println("수정 할 나이를 입력하세요: ");
                    modifyMember.setAge(sc.nextInt());
                    break;
                case 3:
                    System.out.println("수정 할 취미를 입력하세요: ");
                    modifyMember.setHoobies(resetHobbies());    // 배열은 단순 Scanner로 입력받을 수 x
                    break;
                case 4:
                    System.out.println("수정 할 혈액형을 입력하세요: ");
                    modifyMember.setBloodType(resetBloodType());    // enum은 단순 Scanner로 입력받을 수 x
                    break;
                case 9:
                    System.out.println("메인 메뉴로 돌아갑니다. ");
                    return modifyMember;
                default:
                    System.out.println("번호를 다시 제대로 입력해 주세요. ");
            }
        }
    }

    // sc.nextEnum 등이 없기 때문에 따로 구현해주기
    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 할 혈액형을 입력하세요(A, AB, B, O)");
        String bloodType = sc.nextLine();
        BloodType bt = null;
        switch (bloodType) {
            case "A":
                bt = BloodType.A;
                break;
            case "AB":
                bt = BloodType.AB;
                break;
            case "B":
                bt = BloodType.B;
                break;
            case "O":
                bt = BloodType.O;
                break;
        }
        return bt;
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 할 취미의 개수를 입력하세요(1개 이상): ");
        int length = sc.nextInt();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }
        return hobbies;
    }

    // aggregate 의 memeber를
    private static Member signUp() {
        Member member = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.println("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.println("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.println("입력할 취미의 개수를 입력하세요(숫자는 1 이상): ");
        int length = sc.nextInt();
        sc.nextLine();  // 버퍼에 남은 엔터 제거용

        // 입력한 크기(취미 개수)의 스트링 배열 만들기
        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        // 입력받은 혈액형을 BloodType 에 담기
        System.out.println("혈액형을 입력하섹요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = null;
        switch (bloodType) {
            case "A":
                bt = BloodType.A;
                break;
            case "AB":
                bt = BloodType.AB;
                break;
            case "B":
                bt = BloodType.B;
                break;
            case "O":
                bt = BloodType.O;
                break;
        }

        member = new Member(id, pwd, age, hobbies, bt);

        return member;  // 멤버 객체를 채워서 반환
    }

    /* 설명 : 회원 번호를 입력 받아 int 로 반환하는 메소드 */
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 번호를 입력하세요: ");
        return sc.nextInt();
    }
}


package com.min.common;

/* memo : spring-context.xml에서 account 라는 이름으로 빈이 생성됨. */
/* memo : MemberDTO 에 주입되어야 한다.  */
public class PersonalAccount implements Account {
    private final int bankCode;     // 은행 코드
    private final String accNo;     // 계좌 번호
    private int balance;            // 잔액

    // 기본 생성자를 사용했을 떄 에러 -> 상수가 초기화 되지 않기 떄문.
//    public PersonalAccount() {
//    }

    /* memo :  final 이기 때문에 초기값 지정해주어야한다.
     *   값이 들어오면 생성자를 통해 초기화된다. */
    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    // 잔액 조회
    @Override
    public String getBalance() {
        return this.accNo + "게좌의 현재 잔액은 " + this.balance;
    }

    // 입금
    @Override
    public String deposit(int money) {
        String str = "";

        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }
        return str;
    }

    // 출금
    @Override
    public String withdraw(int money) {
        String str = "";

        if (this.balance >= money) {
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다.";
        }
        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}

package com.min.section01.section03.grammer;

public enum UserRole2 {
    GUEST("게스트"), // 생성자라고 판단 ->
    CONSUMER("구매자"),
    PRODUCER("판매자"),
    ADMIN("관리자");

    private final String DESCRIPTION;

    // 각각의 객체가 들어갈 때 생성자라고 생각해서 만들어진다.
    UserRole2(String description) {
        DESCRIPTION = description;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}

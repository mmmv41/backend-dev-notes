package com.min.section01.section03.grammer;

public enum UserRole1 {
    /* memo : 킄래스로 객체를 만들어 각각 들어간다. 모든 상수 필드의 메소드는  */
    GUEST,
    CONSUMER,
    PRODUCER,
    ADMIN;

    public String getNameToLowerCase() {
        return this.name().toLowerCase();
    }
}

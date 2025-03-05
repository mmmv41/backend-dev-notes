package com.min.section03.overriding;

public class SubClass extends SuperClass {

    /* 설명 : 부모 메서드의 헤드부와 일치하게 오버라이딩 */
    @Override
    public void method(int num) {

    }

    /* 설명 : 메서드 이름 변경할 시 오류(새로운 메서드를 생성한게 됨) */
//    @Override
//    public void method1(int num){}
    /* 설명 : 메서드의 반환형(리턴 타입) 변경 시 오류 */
//    @Override
//    public String method(int num){
//        return null;
//    }
    /* 설명 : 메서드의 반환형을 달리 해도 오버라이딩이 성립하는 경우
     *   부모 클래스가 Object 이기 떄문에 (Object는 모든 클래스의 부모이다)
     *   부모 메서드의 리턴 타입이 자식 타입으로는 가능*/
    @Override
    public String method2(int num) {
        return null;
    }

    /* 설명 : 부모 메서드가 private이라면 오버라이딩 할 수 없다.  */
//    @Override
//    private void privateMethod() {}

    /* 설명 : final 메서드는 오버라이딩 불가 */
//    @Override
//    public final void finalMethod() {
//    }
    /* 설명 : protected는 다른 패키지여도 상속 관계이므로 오버라이딩 가능
     *   또한, 더 큰 범위로 접근 제어자를 바꾸는 건 가능하다 (protected -> public) */
    @Override
    //protected void protectedMethod() {}
    public void protectedMethod() {

    }
    /* 설명 : default는 같은 패키지에 있을 때만 오버라이딩이 가능 */
//    @Override
//    void defaultMethod() {}
}

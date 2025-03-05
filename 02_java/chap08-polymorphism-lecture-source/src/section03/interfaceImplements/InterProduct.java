package section03.interfaceImplements;

public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct {
    //    public static final int MAX_NUM = 100; // 고정
    int MAX_NUM = 100; // 상품이 최대 100개만 저장 가능하고 변동 없이 이 값을 활용해라.

    /* 설명. 인터페이스는 생성자를 가질 수 없다. (feat. 객체를 만들 수 없다.) */
//    public InterProduct() {}

    // 반드시 오버라이딩 해야함.
    //    public abstract void nonStaticMethod();
    void nonStaticMethod();

    // 반드시 오버라이딩 할 필요 x
    /* 설명 : static 메서드를 사용하면 메서드와 바디부까지 작성이 가능하다.(JDK 8부터 추가) */
    public static void staticMethod() {

    }

    /* 설명 : non-static 메서드로 default 키워드를 사용하면 메서드와 바디부까지 작성이 가능하다.(JDK 8부터 추가) */
    public default void defaultMethod() {

    }

    /* 설명 : 접근 제어자가 private인 메서드는 메서드와 바디부까지 작성이 가능하다.(default 없이)*/
    private void privateMethod() {

    }

}

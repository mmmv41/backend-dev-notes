package section02.abstractclass;

// 객체를 생성하지 못하는 불완전한 클래스
public abstract class Product {
    private int nonStaticField;
    private static int staticField;

    public Product() {

    }

    public void nonStaticMethod() {

    }

    public static void setStaticField() {

    }

    /* 설명 : 추상 메서드가 하나라도 있다면 해당 클래스는 추상 클래스가 되어야한다. */
    public abstract void abstractMethod();
}

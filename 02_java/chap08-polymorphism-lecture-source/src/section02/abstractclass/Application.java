package section02.abstractclass;

public class Application {
    public static void main(String[] args) {
        //Product p = new Product();

        Phone smartPhone1 = new Phone();
        smartPhone1.abstractMethod();

        Product smartPhone2 = new Phone();
        smartPhone2.abstractMethod();
    }
}

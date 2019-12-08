package exercitii.finall;

public class Child extends Parent {

    Child(String xxx) {
        super(xxx);
    }

    @Override
    protected String metoda() {
        System.out.println(" child method");
        return xxx;
    }
}

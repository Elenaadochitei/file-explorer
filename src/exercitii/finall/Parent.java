package exercitii.finall;

public /*final*/ class Parent {
    protected final String xxx;//="";

    Parent(String xxx) {
        this.xxx = xxx;
    }

    protected /*final*/ String metoda() {
        System.out.println("metoda parent");
        return xxx;
    }
}

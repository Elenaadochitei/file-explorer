package exercitii.imutable;

public /*final*/ class Imutable {

    private final int s;

    public Imutable(int s) {
        this.s = s;
    }

    public /*final*/ int getS() {
        return this.s;
    }
}

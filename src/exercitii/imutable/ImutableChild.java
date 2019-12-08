package exercitii.imutable;

public class ImutableChild extends Imutable {

    private int realValue;

    public ImutableChild(int value) {
        super(value);
        realValue = value;
    }

    public int getS() {
        return realValue;
    }

    public void setValue(int newValue) {
        realValue = newValue;
    }

}

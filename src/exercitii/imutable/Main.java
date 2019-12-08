package exercitii.imutable;


public class Main {

    public static void main(String[] args) {
        ImutableChild obj = new ImutableChild(2);
        Imutable immObj = obj;
        System.out.println(immObj.getS());
        obj.setValue(3);
        System.out.println(immObj.getS());
    }
}

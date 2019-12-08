package nou;

import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) {

        ArrayList<Integer> list= new ArrayList<Integer>();

        list.add(2);
        list.add(3);
        list.add(7);
        list.add(10);
        list.add(0);

        boolean b = false;
        int n = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                System.out.println("gasit");
                b = true;
            }
        }
        if (b == false) {
            System.out.println("gresit");
        }


        int j =- (-3) + 2;
        System.out.println( "wai");
        System.out.println(j);
    }
}

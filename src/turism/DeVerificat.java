package turism;

import java.util.ArrayList;

public class DeVerificat {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(2);
        list.add(1);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                Integer integer = list.get(i);
                Integer integer1 = list.get(j);
                if (integer == integer1) {
                    System.out.println(integer);
                }
            }
        }
    }
}


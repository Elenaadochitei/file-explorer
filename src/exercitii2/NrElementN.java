package exercitii2;

import java.util.ArrayList;

public class NrElementN {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(2);

        int n=2;
        int count=0;

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if(integer==n)
                count++;
        }
        System.out.println(count);
    }
}

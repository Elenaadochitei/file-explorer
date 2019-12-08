package exercitii3;

import turism.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Hotel> h = new ArrayList<>();
        for (int i = 0; true; ) {
            System.out.println("Hello Javatpoint");
            Hotel e = new Hotel();
            h.add(e);
            e.setPrice(123);
            e.setName(i + " Hotel");
        }
    }


}




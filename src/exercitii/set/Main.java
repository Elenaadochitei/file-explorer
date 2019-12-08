package exercitii.set;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        HashSet<String> test= new HashSet<>();
        test.add("Ion");
        test.add(" Costel");
        test.add("Ion");


        Iterator<String> iterator = test.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

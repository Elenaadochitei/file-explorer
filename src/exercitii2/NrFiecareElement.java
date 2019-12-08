package exercitii2;

import java.util.*;

public class NrFiecareElement {
    public static void main(String[] args) {
 /*       ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(2);
        list.add(3);*/

        int[] array = new int[]{2, 0, 2, 3, 3, 5, 5, 2, 10, 100,100};
        int[] fr = new int[array.length];
        int visited = -1;

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    fr[j] = visited;
                }
            }
            if (fr[i] != visited)
                fr[i] = count;
        }
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] != visited)
                System.out.println("Numarul " + array[i] + " apare de " + fr[i]);

        }

        /*Set<Integer> sortare = new HashSet<>(list);
        for (int s : sortare) {
        System.out.println("Nr. " +s+ " apare de : " +Collections.frequency(list, s)+ " ori.");
        }

        ArrayList<Integer> numarLista = new ArrayList<>();

        int i = 0;
        int j = 0;

        for (i = 0; i < list.size(); i++) {
            int count = 0;
            if (!numarLista.contains(list.get(i))) {
                for (j = i; j < list.size(); j++) {
                    if (list.get(i) == list.get(j)) {
                        count++;
                    }
                }
                numarLista.add(list.get(i));
                System.out.println("Nr. " + list.get(i) + " apare de : " + count);
            }
        }
         */

    }
}

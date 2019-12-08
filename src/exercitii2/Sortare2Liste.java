package exercitii2;

import java.util.ArrayList;

public class Sortare2Liste {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(5);
        list.add(7);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        list2.add(12);

        int i=0;
        int j=0;
        ArrayList<Integer> listaSortata = new ArrayList<>();

        for (i = 0; i < list.size(); i++) {
            j++;
            if (j >= list2.size()) {
                for (int k = j-1; k < list.size(); k++) {
                    listaSortata.add(list.get(k));
                }
                break;
            }
            for (j = 0; j < list2.size(); j++) {
                Integer l2 = list2.get(j);
                Integer l1 = list.get(i);


                if (l1 > l2) {
                    listaSortata.add(l2);
                } else {
                    listaSortata.add(l1);
                    i++;
                    j--;
                }

                if (i >= list.size()) {
                    for (int k = j + 1; k < list2.size(); k++) {
                        listaSortata.add(list2.get(k));
                    }
                    break;
                }
            }
        }
        for (int y = 0; y < listaSortata.size(); y++) {
            System.out.println(listaSortata.get(y));
        }
    }
}

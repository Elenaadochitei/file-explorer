package exercitii2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EliminareDuplicate {
    public static void main(String[] args) {

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        System.out.println(numbersList);

        List<Integer> listWithoutDuplicates = numbersList.stream().distinct().collect(Collectors.toList());

        System.out.println(listWithoutDuplicates);

        ArrayList<Integer> listaFaraDuplicate = new ArrayList<>();
        listaFaraDuplicate.add(1);
        listaFaraDuplicate.add(6);
        listaFaraDuplicate.add(3);
        listaFaraDuplicate.add(4);
        listaFaraDuplicate.add(4);
        listaFaraDuplicate.add(6);
        listaFaraDuplicate.add(6);
        listaFaraDuplicate.add(6);
        listaFaraDuplicate.add(6);
        listaFaraDuplicate.add(8);
        listaFaraDuplicate.add(8);
        listaFaraDuplicate.add(1);
        listaFaraDuplicate.add(4);
        listaFaraDuplicate.add(4);
        listaFaraDuplicate.add(4);
        listaFaraDuplicate.add(4);

        int i=0;
        int j=0;

        for (i = 0; i < listaFaraDuplicate.size(); i++) {
            for (j = i+1; j < listaFaraDuplicate.size(); j++) {
                if (listaFaraDuplicate.get(i).equals(listaFaraDuplicate.get(j))) {
                    listaFaraDuplicate.remove(j);
                }
            }
        }
        System.out.println(listaFaraDuplicate);
    }
}

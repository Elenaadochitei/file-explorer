package exercitii;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareLexicographically {
    public static void compareLexicographically() throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        File files;
        File files2;

        while (true) {
            System.out.println("Introduceti primul fisier:");
            files = new File(keyboard.nextLine());
            if (files.exists()) {
                break;
            } else {
                System.out.println("Fisierul este invalid.\n" + "Reintroduceti un fisier valid:");
            }
        }

        while (true) {
            System.out.println("Introduceti al doilea fisier");
            files2 = new File(keyboard.nextLine());
            if (files2.exists()) {
                Scanner sc = new Scanner(files);
                ArrayList<String> list = new ArrayList<>();
                while (sc.hasNext()) {
                    list.add(sc.nextLine());
                }
                Scanner sc1 = new Scanner(files2);
                ArrayList<String> list1 = new ArrayList<>();
                while (sc1.hasNext()) {
                    list1.add(sc1.nextLine());
                }

                if (list.equals(list1)) {
                    System.out.println("Fisierele sunt egale");
                    break;
                } else {
                    System.out.println("Fisierele nu sunt egale");
                    break;
                }
            } else {
                System.out.println("Fisierul este invalid.\n" + "Reintroduceti un fisier valid:");
            }
        }
    }
}


package exercitii;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWord {
    public static void longestWord() throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        File files;
        String max = " ";

        while (true) {
            System.out.println("Introduceti primul fisier:");
            files = new File(keyboard.nextLine());
            if (files.exists()) {

                Scanner sc = new Scanner(files);

                while (sc.hasNext()) {

                    String current = sc.next();

                    if (max.length() < current.length()) {
                        max = current;
                    }
                }
                System.out.println("Cuvantul cel mai lung este: " + max);
               break;

            } else {
                System.out.println("Fisierul este invalid.\n" + "Reintroduceti un fisier valid:");
            }
        }
    }
}
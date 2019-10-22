package exercitii;

import java.io.File;
import java.util.Scanner;

public class DirectorySpecified {
    public static void directorySpecified() {

        System.out.println("Introduceti un fisier:");

        while (true) {

            Scanner keyboard = new Scanner(System.in);
            File files = new File(keyboard.nextLine());
            if (files.exists()) {
                if (files.exists()) {
                    System.out.println("Exists");
                } else {
                    System.out.println("Does not exist");
                }
                break;
            } else {
                System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
            }
        }
    }
}

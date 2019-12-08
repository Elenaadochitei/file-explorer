package exercitii;
import turism.Application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryOrFile {
    public static void directoryOrFile() {
        while (true) {

            Main m = new Main();


            System.out.println("Introduceti un fisier:");

            Scanner keyboard = new Scanner(System.in);
            File files = new File(keyboard.nextLine());

            if (files.exists()) {

                if (files.isDirectory()) {
                    System.out.println(files.getAbsolutePath() + " It is a directory. ");
                } else {
                    System.out.println(files.getAbsolutePath() + " It's not a directory. ");
                }if (files.isFile()) {
                    System.out.println(files.getAbsolutePath() + " It is a file. ");
                } else {
                    System.out.println(files.getAbsolutePath() + " It's not a file. ");
                }
                break;
            } else {
                System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
            }
        }
    }
}


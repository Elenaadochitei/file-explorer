package exercitii;
import java.io.File;
import java.util.Scanner;

public class WritePermission {
    public static void writePermission() {

        System.out.println("Introduceti un fisier:");
        while (true) {

            Scanner keyboard = new Scanner(System.in);
            File files = new File(keyboard.nextLine());

            if (files.exists()) {
                if (files.canWrite()) {
                    System.out.println(files.getAbsolutePath() + " Has write ");
                } else {
                    System.out.println(files.getAbsolutePath() + " Not write ");
                }
                if (files.canRead()) {
                    System.out.println(files.getAbsolutePath() + " Has read ");
                } else {
                    System.out.println(files.getAbsolutePath() + " Not read ");
                }
                break;
            } else {
                System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
            }
        }
    }
}
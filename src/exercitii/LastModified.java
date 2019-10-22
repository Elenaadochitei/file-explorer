package exercitii;
import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class LastModified {
    public static void lastModified() {

        System.out.println("Introduceti un fisier:");
        while (true){

            Scanner keyboard = new Scanner(System.in);
            File files = new File(keyboard.nextLine());

            if (files.exists()) {
                Date date = new Date(files.lastModified());
                System.out.println("The last modified was made in: " + date);
                break;
            } else {
                System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
            }
        }
    }
}

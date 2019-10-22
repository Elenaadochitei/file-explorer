package exercitii;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void readFile() {
        Scanner keyboard = new Scanner(System.in);
        File files;

        while (true) {
            System.out.println("Introduceti primul fisier:");
            files = new File(keyboard.nextLine());

            try {
                Scanner sc = new Scanner(files);

                while (true) {
                    boolean next = sc.hasNext();
                    if (next) {
                        String path = sc.next();
                        System.out.println("Am introdus:" + path);
                    }else {
                        System.out.println("S.a terminat afisarea.");
                        break;
                    }
                }
            break;
            } catch (FileNotFoundException f) {
                System.out.println("Fisierul este invalid.\n" + "Reintroduceti un fisier valid:");
            }
        }
    }
}


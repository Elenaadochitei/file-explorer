package exercitii;
import java.io.File;
import java.util.Scanner;

public class GetSize {
    public static void getSize() {

        System.out.println("Introduceti un fisier:");
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            File files = new File(keyboard.nextLine());

            if (files.exists()) {
                System.out.println("the size is: " + filesize_in_Bytes(files));
                System.out.println("the size is: " + filesize_in_kiloBytes(files));
                System.out.println("the size is: " + filesize_in_megaBytes(files));
                break;
            } else
            System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
        }
    }
    private static String filesize_in_megaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }
    private static String filesize_in_kiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }
    private static String filesize_in_Bytes(File file) {
        return file.length() + " bytes";
    }
}


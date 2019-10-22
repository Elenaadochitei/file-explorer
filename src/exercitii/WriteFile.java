package exercitii;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WriteFile {
    public static void main(String[] args) {
        System.out.println("Introduceti nume fisier:");
        Scanner keyboard = new Scanner(System.in);
        PrintWriter at = null;
        try {
            at = new PrintWriter(keyboard.nextLine());
            System.out.println("Introducere text:");
            while (true) {
                String v = keyboard.nextLine();
                at.print(v);

                if (v.endsWith(".")) {
                    System.out.println("Aici se opreste programul.");
                    break;
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("Suntetem aici");
        } finally {
            at.close();
        }
    }
}

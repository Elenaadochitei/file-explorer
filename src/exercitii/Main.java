package exercitii;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        while (true) {
            afisareMeniu();
            Scanner keyboard = new Scanner(System.in);
            String comanda = keyboard.next();

            if (comanda.equals("1")) {
                CompareLexicographically.compareLexicographically();
            } else if (comanda.equals("2")) {
                DirectoryOrFile.directoryOrFile();
            } else if (comanda.equals("3")) {
                DirectorySpecified.directorySpecified();
            } else if (comanda.equals("4")) {
                Extensions.extensions();
            } else if (comanda.equals("5")) {
                FileName.fileName();
            } else if (comanda.equals("6")) {
                GetSize.getSize();
            } else if (comanda.equals("7")) {
                LastModified.lastModified();
            } else if (comanda.equals("8")) {
                ReadInputConsole.readInputConsole();
            } else if (comanda.equals("9")) {
                WritePermission.writePermission();
            } else if (comanda.equals("10")) {
                ReadFile.readFile();
            } else if (comanda.equals("11")){
                LongestWord.longestWord();
            } else if (comanda.equals("12")) {
                System.out.println("Inchide aplicatia");
                break;
            }
        }
    }

    private static void afisareMeniu() {

        System.out.println("Se afiseaza meniul");
        System.out.println("1.Comparare lexicographically");
        System.out.println("2.Directory or file");
        System.out.println("3.Directory specified");
        System.out.println("4.Extensions");
        System.out.println("5.File name");
        System.out.println("6.Get size");
        System.out.println("7.Last modified");
        System.out.println("8.Read input console");
        System.out.println("9.Write permission");
        System.out.println("10.ReadFile");
        System.out.println("11.LongestWord");
        System.out.println("12.Exit");
        System.out.println("Introduceti cifra corespunzatoare clasei: ");

    }
}







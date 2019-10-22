package exercitii;
import java.io.File;
import java.util.Scanner;

public class Extensions {

    public static void extensions() {
        System.out.println("Introduceti un fisier:");
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            File selectedPath = new File(keyboard.nextLine());
            if (selectedPath.exists()) {
 /*
                //ALTERNATIVA LA IF_ul cu " isDirectory()"
                if (selectedPath.isFile()) {
                    System.out.println("Trebuie sa introduci un nume folder");
                    continue;
                }
*/
                if (selectedPath.isDirectory()) {

                    System.out.println("Se introduce numele extensiei:");
                    String extensie = keyboard.nextLine();

                    String[] filesFromFolder = selectedPath.list(); //return list de fisiere din "selectedPath" ( daca e folder)
                    for (int i = 0; i < filesFromFolder.length; i++) {
                        if (filesFromFolder[i].endsWith(extensie)){
                            System.out.println(filesFromFolder[i]);
                        }
                    }break;
                } else {
                    System.out.println("Trebuie sa introduci un nume folder");
                }
            } else {
                System.out.println("Fisierul este invalid.\nReintroduceti un fisier valid:");
            }
        }
    }
}

package file;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args)
            throws FileNotFoundException
    {
        File file = new File("/Users/Rodica/Desktop/casatorie.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}

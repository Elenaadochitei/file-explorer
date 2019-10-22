package exercitii;

import java.io.File;

public class FileName {

    public static void fileName() {

        String path = " conturi ";
        File file = new File(path);
        System.out.println("The file name is: " + path);
    }
}

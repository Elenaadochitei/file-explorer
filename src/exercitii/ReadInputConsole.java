package exercitii;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputConsole {

    public static void readInputConsole() throws IOException {

        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write something...");
        String readtoconsole = R.readLine();
        System.out.println("I write: " + readtoconsole);

    }
}

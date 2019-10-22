package exercitii;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteFile {
    public static void main(String[] args) {

            try {
                FileWriter writer = new FileWriter("MyFile.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.write("Hello World");
                bufferedWriter.newLine();
                bufferedWriter.write("See You Again!");
                bufferedWriter.newLine();
                bufferedWriter.write("Eu sunt!");

                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



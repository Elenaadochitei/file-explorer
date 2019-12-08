package turism;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {

        while (true) {
            try {
                Path path = Paths.get("/Users/Rodica/Desktop/Elena/src/turism/bookHistory");
                List<String> bookHistory = Files.readAllLines(path, StandardCharsets.UTF_8);

                Scanner keyboard = new Scanner(System.in);
                System.out.println("1.Introduceti numele N:nume :");
                String nume = keyboard.nextLine();
                System.out.println("2.Introduceti hotelul H:hotel :");
                String hotel = keyboard.nextLine();

                for (int i = 0; i < bookHistory.size(); i++) {
                    if (nume.equals(bookHistory.get(i))) {
                        for (int j = i + 1; j < bookHistory.size(); j++) {
                            if (hotel.equals(bookHistory.get(j))) {
                                for (int x = j + 1; x < bookHistory.size(); x++) {
                                    if (bookHistory.get(x).startsWith("R:")) {

                                        int a = x--;
                                        int position = a;
                                        System.out.println("Introduceti ratingul: ");
                                        int rating = keyboard.nextInt();

                                        if(rating <= 10){
                                            System.out.println("Se adauga rating.");

                                            bookHistory.set(position, "R:" + rating);
                                            Files.write(path, bookHistory, StandardCharsets.UTF_8);

                                            System.out.println("Done");
                                            System.out.println("Apasati tasta 6 pentru Exit.");
                                            break;
                                        }
                                        else{
                                            System.out.println("Introduceti un rating valid.");
                                        }


                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                String comanda = keyboard.next();
                if (comanda.equals("6")) {
                    System.out.println("Exit");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

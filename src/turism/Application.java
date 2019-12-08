package turism;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {
    private static ArrayList<Destinatii> destinations;

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String rol = login(args[1]);
        ArrayList<Hotel> hotels = readDestinationsComplete(args[0]);
        meniu(keyboard, rol, hotels, args[0], args[2]);
        String path = args[0];
        String pathh = args[1];
        String pathhh = args[2];
    }

    /**
     * Read from file and populate destinations. After that, also populate hotles and return it.
     *
     * @return
     * @throws IOException
     */
    public static ArrayList<Hotel> readDestinationsComplete(String path) throws IOException {
        List<String> fileList = readDestinationFileToFileListString(path);
        populateDestinations(fileList);
        return populateHotels();
    }

    private static void meniu(Scanner keyboard, String rol, ArrayList<Hotel> hotels, String path, String pathhh) {
        while (true) {
            if (rol.equals("admin")) {
                if (adminMeniu(keyboard, path, pathhh)) break;
            } else if (rol.equals("client")) {

                if (clientMeniu(keyboard, hotels, path, pathhh)) break;
            }
        }
    }

    private static boolean adminMeniu(Scanner keyboard, String path, String pathhh) {

        System.out.println("Se afiseaza meniul");
        System.out.println("1.Afisare tara, oras, hotel");
        System.out.println("2.Introduceti o tara/oras/hotel/rating/nr.camere/pret.");
        System.out.println("3.Modificati numar camere si pret.");
        System.out.println("4.Modificare nr. camere dupa rezervare.");
        System.out.println("5.Exit.");
        String comanda = keyboard.next();
        if (comanda.equals("1")) {
            afisareTaraOrasHotel();
        }
        if (comanda.equals("2")) {
            introducereInFisier(path);
        }
        if (comanda.equals("3")) {
            modificareNCsiP(path);
        }
        if (comanda.equals("4")) {
            modificareNc(path, pathhh);
        }
        if (comanda.equals("5")) {
            System.out.println("Exit");
            return true;
        }
        return false;
    }

    private static boolean clientMeniu(Scanner keyboard, ArrayList<Hotel> hotels, String path, String pathhh) {
        System.out.println("Se afiseaza meniul");
        System.out.println("9.Afisati daca o tara exista sau nu.");
        System.out.println("10.Afisare tara, oras, hotel");
        System.out.println("11.Afisare hotel cu acelasi pret.");
        System.out.println("12.Sortare hotel dupa pret");
        System.out.println("13.Sortare hotel dupa rating.");
        System.out.println("14.Scriere rating.");
        System.out.println("15.Exit");

        String comanda2 = keyboard.next();

        if (comanda2.equals("9")) {
            validareTara();
        }
        if (comanda2.equals("10")) {
            afisareTaraOrasHotel();
        }
        if (comanda2.equals("11")) {
            printHotelsWithSamePrice(hotels);
        }
        if (comanda2.equals("12")) {
            sortByPrice(hotels);
        }
        if (comanda2.equals("13")) {
            sortByRating(hotels);
        }
        if (comanda2.equals("14")) {
            ofRating(path, pathhh);
        }
        if (comanda2.equals("15")) {
            System.out.println("Exit");
            return true;
        }
        return false;
    }

    private static String login(String pathh) throws FileNotFoundException {
        String rol = null;
        while (true) {

            File f1 = new File(pathh);
            Scanner sc = new Scanner(f1);
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introduceti username: ");
            String user = keyboard.nextLine();
            System.out.println("Introduceti Passoword: ");
            String password = keyboard.nextLine();
            boolean b = false;
            while (sc.hasNext()) {
                if (sc.nextLine().equals(user)) {
                    if (sc.nextLine().equals(password)) {
                        rol = sc.nextLine();
                        System.out.println("Rolul lui este: " + rol);
                        b = true;

                    } else {
                        sc.nextLine();
                    }
                } else {
                    sc.nextLine();
                    sc.nextLine();
                }
            }
            if (b == false) {
                System.out.println("User inexistent");
            } else {
                break;
            }
        }
        return rol;
    }

    private static List<String> readDestinationFileToFileListString(String path) throws IOException {

        Path path1 = Paths.get(path);

        List<String> fileList = Files.readAllLines(path1, StandardCharsets.UTF_8);
        for (int i = 0; i < fileList.size(); i++) {
            fileList.set(i, fileList.get(i).trim());
        }
        return fileList;
    }

    private static void introducereInFisier(String path) {

        while (true) {
            try {
                Path path1 = Paths.get(path);
                List<String> lines = Files.readAllLines(path1, StandardCharsets.UTF_8);
                Scanner keyboard = new Scanner(System.in);

                System.out.println("1.In ce oras?\nOrasul se introduce in formatul CY-Oras:");
                String oras = keyboard.nextLine();

                boolean b = true;
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).trim().equals(oras)) {
                        for (int j = i + 1; j < lines.size(); j++) {
                            if (lines.get(j).trim().startsWith("C-") || lines.get(j).trim().startsWith("CY-")) {
                                int a = j--;
                                int position = a;

                                System.out.println("2.Introduceti nume hotel: ");
                                String hotel = keyboard.nextLine();
                                lines.add(position, "\t\tH-" + hotel);
                                Files.write(path1, lines, StandardCharsets.UTF_8);


                                int rating;
                                while (true) {
                                    System.out.println("3.Introduceti ratingul: ");
                                     rating = keyboard.nextInt();
                                    if (rating <= 10) {
                                        System.out.println("Se adauga rating.");
                                        lines.add(position + 1, "\t\t\tR-" + rating);
                                        Files.write(path1, lines, StandardCharsets.UTF_8);
                                        break;
                                    } else {
                                        System.out.println("Introduceti un rating valid.");
                                    }
                                }

                                int nrCamere;
                                while (true) {
                                    try {
                                        System.out.println("4.Introduceti numarul de camere: ");
                                         nrCamere = keyboard.nextInt();
                                        if (b) {
                                            System.out.println("Se adauga nrCamere.");
                                            lines.add(position + 2, "\t\t\tNC-" + nrCamere);
                                            Files.write(path1, lines, StandardCharsets.UTF_8);
                                            break;
                                        }
                                    } catch (InputMismatchException w) {
                                        System.out.println("Nr de camere este invalid.");
                                        keyboard.nextLine();
                                    }
                                }

                                int pret;
                                while (true) {
                                    try {
                                        System.out.println("5.Introduceti pretul: ");
                                         pret = keyboard.nextInt();
                                        if (b) {
                                            System.out.println("Se adauga pretul.");
                                            lines.add(position + 3, "\t\t\tP-" + pret);
                                            Files.write(path1, lines, StandardCharsets.UTF_8);
                                            break;
                                        }
                                    } catch (InputMismatchException w1) {
                                        System.out.println("Pretul este invalid.");
                                        keyboard.nextLine();
                                    }
                                }


                                for (int c = 0; c < destinations.size(); c++) {
                                    Destinatii s1 = destinations.get(c);
                                    ArrayList<City> cities = s1.getCities();
                                    for (int d = 0; d < cities.size(); d++) {
                                        City city = cities.get(d);
                                        ArrayList<Hotel> hotels = city.getHotels();
                                        if (hotels.get(d).equals(hotel)) {
                                            for (int e = 0; e < hotels.size(); e++) {
                                                Hotel hotelNume = hotels.get(e);
                                                if (hotelNume.getName().equals(hotel)) {
                                                    hotelNume.setRating(rating);
                                                    hotelNume.setPrice(pret);
                                                    hotelNume.setAvailableRooms(nrCamere);
                                                }
                                            }
                                        }
                                    }
                                }


                                System.out.println("Done");
                                b = false;
                                System.out.println("Apasati tasta 6 pentru Exit.");
                                break;
                            }
                        }
                        break;
                    }
                }
                // if(b)  =  b == true
                // if(!b)    b == false
                if (!b) {
                    String comanda = keyboard.next();
                    if (comanda.equals("6")) {
                        System.out.println("Exit");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Hotel> populateHotels() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (int z = 0; z < destinations.size(); z++) {
            Destinatii dest = destinations.get(z);
            for (int y = 0; y < dest.getCities().size(); y++) {
                City city = dest.getCities().get(y);
                for (int w = 0; w < city.getHotels().size(); w++) {
                    Hotel h = city.getHotels().get(w);
                    hotels.add(h);
                }
            }
        }

        return hotels;
    }

    private static void validareTara() {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            boolean b = true;
            int r;
            System.out.println("Introduceti o tara:");
            String numeCautat = keyboard.nextLine();
            for (r = 0; r < destinations.size(); r++) {
                Destinatii s1 = destinations.get(r);
                if (s1.getCountry().equals(numeCautat)) {
                    System.out.println("Tara exista.");
                    b = false;
                    System.out.println("Done");
                    System.out.println("Apasati tasta 6 pentru Exit.");
                    break;
                }
            }
            if (!b) {
                String comanda = keyboard.next();
                if (comanda.equals("6")) {
                    System.out.println("Exit");
                    break;
                }
            }
        }
    }

    private static void afisareTaraOrasHotel() {


        for (int z = 0; z < destinations.size(); z++) {
            Destinatii destinatii = destinations.get(z);
            System.out.println(destinatii.getCountry());
            ArrayList<City> cities = destinatii.getCities();

            for (int w = 0; w < cities.size(); w++) {
                City city = cities.get(w);
                String name = city.getName();
                System.out.println(name);
                ArrayList<Hotel> hotels = city.getHotels();

                for (int x = 0; x < hotels.size(); x++) {
                    Hotel hotel = hotels.get(x);
                    String name1 = hotel.getName();
                    System.out.println(name1);
                    int rating = hotel.getRating();
                    int availableRooms = hotel.getAvailableRooms();
                    double price = hotel.getPrice();
                }
            }
        }
    }

    private static void populateDestinations(List<String> fileList) {
        destinations = new ArrayList<>();
        Destinatii d = new Destinatii();
        for (int i = 0; i < fileList.size(); i++) {
            String s = fileList.get(i);
            if (s.startsWith("C-")) {
                d = new Destinatii();
                d.setCountry(s);
                destinations.add(d);
                d.setCities(new ArrayList<>());

                for (int j = i + 1; j < fileList.size(); j++) {
                    String s1 = fileList.get(j);
                    if (s1.startsWith("CY-")) {
                        City city = new City();
                        city.setName(s1);
                        d.getCities().add(city);
                        city.setHotels(new ArrayList<>());

                        for (int k = j + 1; k < fileList.size(); k++) {
                            String s2 = fileList.get(k);
                            if (s2.startsWith("H-")) {
                                Hotel hotel = new Hotel();
                                hotel.setName(s2);
                                city.getHotels().add(hotel);

                                for (int m = k + 1; m < fileList.size(); m++) {

                                    String s3 = fileList.get(m);
                                    if (s3.startsWith("R-")) {
                                        String[] split = s3.split("-");
                                        Integer rating = Integer.valueOf(split[1]);
                                        hotel.setRating(rating);
                                    }
                                    if (s3.startsWith("NC-")) {
                                        String[] split = s3.split("-");
                                        Integer room = Integer.valueOf(split[1]);
                                        hotel.setAvailableRooms(room);
                                    }
                                    if (s3.startsWith("P-")) {
                                        String[] split = s3.split("-");
                                        Double price = Double.valueOf(split[1]);
                                        hotel.setPrice(price);
                                    }
                                    if (s3.startsWith("CY-") || s3.startsWith("C-") || s3.startsWith("H-")) {
                                        k = m;
                                        k--;
                                        break;
                                    }
                                }
                            }
                            if (s2.startsWith("CY-")) {
                                j = k;
                                j--;
                                break;
                            }
                            if (s2.startsWith("C-")) {
                                i = k;
                                i--;
                                j = k;
                                j--;
                                break;
                            }
                        }
                    }
                    if (s1.startsWith("C-")) {
                        i = j;
                        i--;
                        break;
                    }
                }
            }
        }
    }

    private static void sortByRating(ArrayList<Hotel> hotels) {

        System.out.println("Lista sorata dupa rating este: ");
        ArrayList<Integer> ratingSortat = new ArrayList<>();

        for (int y = 0; y < hotels.size(); y++) {
            for (int x = y + 1; x < hotels.size(); x++) {
                Hotel hotel3 = hotels.get(y);
                Hotel hotel4 = hotels.get(x);
                if (hotel3.getRating() > hotel4.getRating()) {
                    Hotel aux = hotel3;
                    hotels.set(y, hotels.get(x));
                    hotels.set(x, aux);
                }
            }
        }
        for (int z = 0; z < hotels.size(); z++) {
            System.out.println(hotels.get(z));
        }
    }

    private static void printHotelsWithSamePrice(ArrayList<Hotel> hotels) {
        System.out.println("Hoteluri sunt:");
        for (int n = 0; n < hotels.size(); n++) {
            for (int f = n + 1; f < hotels.size(); f++) {
                Hotel hotel1 = hotels.get(n);
                Hotel hotel2 = hotels.get(f);
                if (hotel1.getPrice() == hotel2.getPrice()) {
                    System.out.println(hotel1 + "  " + hotel2);
                    //break;
                }
            }
        }
    }

    private static void sortByPrice(ArrayList<Hotel> hotels) {

        System.out.println("Lista sortata dupa preturi este: ");
        ArrayList<Integer> preturiSortate = new ArrayList<>();

        for (int i = 0; i < hotels.size(); i++) {
            for (int j = i + 1; j < hotels.size(); j++) {
                Hotel hotel3 = hotels.get(i);
                Hotel hotel4 = hotels.get(j);
                if (hotel3.getPrice() > hotel4.getPrice()) {
                    Hotel aux = hotel3;
                    hotels.set(i, hotels.get(j));
                    hotels.set(j, aux);
                }
            }
        }

        for (int z = 0; z < hotels.size(); z++) {
            System.out.println(hotels.get(z));
        }
    }

    private static void ofRating(String path, String pathhh) {
        while (true) {
            try {
                Path path1 = Paths.get(path);
                List<String> lines = Files.readAllLines(path1, StandardCharsets.UTF_8);

                Path path2 = Paths.get(pathhh);
                List<String> bookHistory = Files.readAllLines(path2, StandardCharsets.UTF_8);


                Map<String, Set<String>> hm = new HashMap<>();

                Scanner keyboard2 = new Scanner(System.in);
                System.out.println("1.Introduceti numele N:nume :");
                String nume = keyboard2.nextLine();
                System.out.println("2.Introduceti hotelul H:hotel :");
                String hotel = keyboard2.nextLine();
                boolean b = true;

                /*for (int i = 0; i < bookHistory.size(); i++) {
                    if (nume.equals(bookHistory.get(i))) {
                        for (int j = i + 1; j < bookHistory.size(); j++) {
                            if (hotel.equals(bookHistory.get(j))) {
                                for (int x = j + 1; x < bookHistory.size(); x++) {
                                    if (bookHistory.get(x).startsWith("R:")) {

                                        if (b) {
                                            System.out.println("ratingul este " + bookHistory.get(x));
                                        }

                 */

                int ii;
                System.out.println("Introduceti ratingul: ");
                int rating = keyboard2.nextInt();
                for (ii = 0; ii < bookHistory.size(); ii++) {
                    if (hm.get(bookHistory.get(ii)) == null) {
                        hm.put(bookHistory.get(ii), new HashSet<>());
                        hm.get(bookHistory.get(ii)).add(bookHistory.get(++ii));
                    } else {
                        hm.get(bookHistory.get(ii)).add(bookHistory.get(++ii));
                    }

                    if (hm.get(hotel) == null) {
                        System.out.println("Hotel invalid.");
                    } else {
                        if (hm.get(hotel).contains(nume)) {
                            //System.out.println("Ofera rating.");

                            if (rating <= 10 & rating >= 0) {
                                System.out.println("Se adauga rating.");
                                int a = ++ii;
                                int position = a;
                                bookHistory.add(position, "R:" + rating);
                                Files.write(path2, bookHistory, StandardCharsets.UTF_8);
                                break;

                            } else {
                                System.out.println("Introduceti un rating valid.");
                            }
                        } else {
                            System.out.println("Nu ati stat la hotelul " + hotel);
                        }
                    }
                }


                for (int c = 0; c < destinations.size(); c++) {
                    Destinatii s1 = destinations.get(c);
                    ArrayList<City> cities = s1.getCities();
                    for (int d = 0; d < cities.size(); d++) {
                        City city = cities.get(d);
                        ArrayList<Hotel> hotels = city.getHotels();
                        if (hotels.get(d).equals(hotel)) {
                            for (int e = 0; e < hotels.size(); e++) {
                                Hotel hotelNume = hotels.get(e);
                                if (hotelNume.getName().equals(hotel)) {
                                    hotelNume.setRating(rating);
                                }
                            }
                        }
                    }
                }

                System.out.println("Done");
                System.out.println("Apasati tasta 6 pentru Exit.");
                if (b) {
                    String comanda = keyboard2.next();
                    if (comanda.equals("6")) {
                        System.out.println("Exit");
                        break;
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void modificareNc(String path, String pathhh) {
        Scanner keyboard1 = new Scanner(System.in);
        while (true) {
            try {
                Path path1 = Paths.get(path);
                List<String> lines = Files.readAllLines(path1, StandardCharsets.UTF_8);

                System.out.println("1.In ce oras?\nOrasul se introduce : CY-Nume Oras:");
                String oras = keyboard1.nextLine();

                System.out.println("2.In ce hotel?\nHotelul se introduce : H-Nume Hotel");
                String hotel = keyboard1.nextLine();

                boolean b = true;
                for (int i = 0; i < lines.size(); i++) {
                    if (oras.equals(lines.get(i).trim())) {
                        for (int j = i + 1; j < lines.size(); j++) {
                            if (hotel.equals(lines.get(j).trim())) {
                                for (int x = j + 1; x < lines.size(); x++) {
                                    if (lines.get(x).trim().startsWith("NC-")) {

                                        String nc = lines.get(x);
                                        System.out.println(nc);
                                        String[] split = nc.split("-");
                                        Integer ncamere = Integer.valueOf(split[1]);
                                        int a = x--;
                                        int position = a;

                                        while (true) {
                                            try {
                                                System.out.println("2.Introduceti numarul de camere: ");
                                                int nrCamere = keyboard1.nextInt();
                                                if (b) {
                                                    if (nrCamere < ncamere) {
                                                        System.out.println("Avem disponibilitate");


                                                    } else {
                                                        System.out.println("Nu avem disponibilitate");
                                                    }
                                                    int sum = ncamere - nrCamere;
                                                    System.out.println("Mai avem disponibil " + sum + " camere.");
                                                    lines.set(position, "\t\t\tNC-" + sum);
                                                    Files.write(path1, lines, StandardCharsets.UTF_8);

                                                    for (int c = 0; c < destinations.size(); c++) {
                                                        Destinatii s1 = destinations.get(c);
                                                        ArrayList<City> cities = s1.getCities();
                                                        for (int d = 0; d < cities.size(); d++) {
                                                            City city = cities.get(d);
                                                            ArrayList<Hotel> hotels = city.getHotels();
                                                            if (cities.get(d).equals(oras)) {
                                                                for (int e = 0; e < hotels.size(); e++) {
                                                                    Hotel hotelNume = hotels.get(e);
                                                                    if (hotelNume.getName().equals(oras)) {
                                                                        hotelNume.setAvailableRooms(nrCamere);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    break;
                                                }
                                            } catch (InputMismatchException w) {
                                                System.out.println("Nr de camere este invalid.");
                                                keyboard1.nextLine();
                                            }
                                        }

                                        Path path2 = Paths.get(pathhh);
                                        List<String> bookHistory = Files.readAllLines(path2, StandardCharsets.UTF_8);

                                        int position1 = 0;


                                        System.out.println("Done, ati inchiriat de la noi.");

                                        System.out.println("Introduceti numele: ");
                                        String nume = keyboard1.next();
                                        System.out.println("Introduceti hotelul: ");
                                        String hotelInchiriat = keyboard1.next();

                                        bookHistory.add(position1, "N:" + nume);
                                        Files.write(path2, bookHistory, StandardCharsets.UTF_8);

                                        bookHistory.add(position1, "H:" + hotelInchiriat);
                                        Files.write(path2, bookHistory, StandardCharsets.UTF_8);

                                        b = false;
                                        System.out.println("Apasati tasta 6 pentru Exit.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!b) {
                    String comanda = keyboard1.next();
                    if (comanda.equals("6")) {
                        System.out.println("Exit");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void modificareNCsiP(String path) {
        while (true) {
            try {
                Scanner keyboard1 = new Scanner(System.in);

                Path path1 = Paths.get(path);
                List<String> lines = Files.readAllLines(path1, StandardCharsets.UTF_8);

                System.out.println("1.In ce oras?\nOrasul se introduce : CY-Nume Oras:");
                String oras = keyboard1.nextLine();

                System.out.println("2.In ce hotel?\nHotelul se introduce : H-Nume Hotel");
                String hotel = keyboard1.nextLine();

                boolean b = true;
                for (int i = 0; i < lines.size(); i++) {
                    if (oras.equals(lines.get(i).trim())) {
                        for (int j = i + 1; j < lines.size(); j++) {
                            if (hotel.equals(lines.get(j).trim())) {
                                for (int x = j + 1; x < lines.size(); x++) {
                                    if (lines.get(x).trim().startsWith("NC-") || lines.get(x).trim().startsWith("P-")) {
                                        int a = x--;
                                        int position = a;

                                        System.out.println("2.Introduceti numarul de camere: ");
                                        int nrCamere = keyboard1.nextInt();
                                        while (true) {
                                            try {
                                                if (b) {
                                                    System.out.println("Se adauga nrCamere.");
                                                    lines.set(position, "\t\t\tNC-" + nrCamere);
                                                    Files.write(path1, lines, StandardCharsets.UTF_8);
                                                    break;
                                                }
                                            } catch (InputMismatchException w) {
                                                System.out.println("Nr de camere este invalid.");
                                                keyboard1.nextLine();
                                            }
                                        }

                                        System.out.println("3.Introduceti pretul: ");
                                        int pret = keyboard1.nextInt();
                                        while (true) {
                                            try {
                                                if (b) {
                                                    System.out.println("Se adauga pretul.");
                                                    lines.set(position + 1, "\t\t\tP-" + pret);
                                                    Files.write(path1, lines, StandardCharsets.UTF_8);
                                                    break;
                                                }
                                            } catch (InputMismatchException w1) {
                                                System.out.println("Pretul este invalid.");
                                                keyboard1.nextLine();
                                            }
                                        }

                                        for (int c = 0; c < destinations.size(); c++) {
                                            Destinatii s1 = destinations.get(c);
                                            ArrayList<City> cities = s1.getCities();
                                            for (int d = 0; d < cities.size(); d++) {
                                                City city = cities.get(d);
                                                ArrayList<Hotel> hotels = city.getHotels();
                                                if (cities.get(d).equals(oras)) {
                                                    for (int e = 0; e < hotels.size(); e++) {
                                                        Hotel hotelNume = hotels.get(e);
                                                        if (hotelNume.getName().equals(oras)) {
                                                            hotelNume.setAvailableRooms(nrCamere);
                                                            hotelNume.setPrice(pret);
                                                        }
                                                    }
                                                }
                                            }
                                        }


                                        System.out.println("Done");
                                        b = false;
                                        System.out.println("Apasati tasta 6 pentru Exit.");
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                if (!b) {
                    String comanda = keyboard1.next();
                    if (comanda.equals("6")) {
                        System.out.println("Exit");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

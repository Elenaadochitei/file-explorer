package file;

import bank.Account;
import bank.Bank;
import bank.CurrentAccount;
import bank.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountFromFile {
    public static void main(String[] args){
        Bank brd = createBank();
        Scanner sc = importFile();
        readAccountsFromFile(brd, sc);
        printAccounts(brd);
    }

    private static Bank createBank() {
        Bank brd = new Bank();
        brd.setAccounts(new ArrayList<>());
        return brd;
    }

    private static Scanner importFile() {

        while (true) {
            try {
                System.out.println("Se introduce numele fisierului");
                Scanner keyboard = new Scanner(System.in);
                File file = new File(keyboard.next());
                Scanner scanner = new Scanner(file);
                return scanner;
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        }
    }


    private static void printAccounts(Bank brd) {
        for (int i = 0; i < brd.getAccounts().size(); i++) {
            System.out.println(brd.getAccounts().get(i));
        }
    }

    private static void readAccountsFromFile(Bank brd, Scanner sc) {
        while (sc.hasNextLine()) {
            String accountType = sc.nextLine();
            manageAccountByType(brd, sc, accountType);
        }
    }

    private static void manageAccountByType(Bank brd, Scanner sc, String accountType) {
        if (accountType.equals("a")) {
            account(brd, sc);
        } else {
            if (accountType.equals("sa")) {
                savingAccount(brd, sc);

            } else {
                if (accountType.equals("ca")) {
                    currentAccount(brd, sc);
                }
            }
        }
    }

    private static void account(Bank brd, Scanner sc) {
        try {
            int accNr = sc.nextInt();
            Account account = new Account(accNr);
            double bal = sc.nextDouble();
            account.setBalance(bal);
            brd.deschidereCont(account);
        }
        catch (InputMismatchException i){
            System.out.println("Format fisier invalid pentru a");
            sc.nextLine();
            sc.nextLine();
        }
    }

    private static void savingAccount(Bank brd, Scanner sc) {
        try {
            int accNr = sc.nextInt();
            SavingsAccount sa = new SavingsAccount(accNr);
            double bal = sc.nextDouble();
            sa.setBalance(bal);
            double interest = sc.nextDouble();
            sa.setInterest(interest);
            brd.deschidereCont(sa);
        }
        catch (InputMismatchException i){
            System.out.println("Format fisier invlid pentru sa");
        }
        sc.nextLine();
    }

    private static void currentAccount(Bank brd, Scanner sc) {
        try {
            int accNr = sc.nextInt();
            CurrentAccount ca = new CurrentAccount(accNr);
            double bal = sc.nextDouble();
            ca.setBalance(bal);
            brd.deschidereCont(ca);
            double descoperire = sc.nextDouble();
            ca.setDescoperire(descoperire);
        }
        catch (InputMismatchException i){
            System.out.println("Format fisier invalid pentru sc");
        }
        sc.nextLine();
    }
}
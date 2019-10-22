package file;

import bank.Account;
import bank.Bank;
import bank.CurrentAccount;
import bank.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Bank brd = new Bank();
        brd.setAccounts(new ArrayList<>());

        File file = new File("/Users/Rodica/Desktop/conturi.txt");

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {

            Account a;
            String accountType = sc.nextLine();
            if (accountType.equals("a")) {
                int accNr = sc.nextInt();
                double bal = sc.nextDouble();
                a = new Account(accNr);
                a.setBalance(bal);
            } else {
                if (accountType.equals("sa")) {
                    int accNr = sc.nextInt();
                    a = new SavingsAccount(accNr);
                    double bal = sc.nextDouble();
                    a.setBalance(bal);
                    double interest = sc.nextDouble();
                    ((SavingsAccount) a).setInterest(interest);
                } else {
                    //if (accountType.equals("ca")) {
                    int accNr = sc.nextInt();
                    a = new CurrentAccount(accNr);
                    double bal = sc.nextDouble();
                    a.setBalance(bal);
                    double descoperire = sc.nextDouble();
                    ((CurrentAccount) a).setDescoperire(descoperire);


                }
            }
            brd.deschidereCont(a);

        }
    }
}

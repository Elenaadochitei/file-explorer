package bank;

import java.util.ArrayList;

public class MainBank {
    public static void main(String[] args) {
        Account a = new Account(123);

        a.deposit(5);

        a.withdraw(2);

        Account a1 = new Account(321);

        a1.deposit(5);

        a.transfer(a1, 5);
        System.out.println(a);
        System.out.println(a1);

        a.changeAccNr(a1);

        System.out.println(a + "Dupa schimbare");
        System.out.println(a1 + "Dupa schimbare");

//  --------  Testing savings Accounts

        SavingsAccount sa = new SavingsAccount(10);
        sa.deposit(100);
        System.out.println(sa);

        SavingsAccount sa1 = new SavingsAccount(12);
        sa1.deposit(10);
        sa1.withdraw(5);
        System.out.println(sa1);

        CurrentAccount sa2 = new CurrentAccount(11);
        sa2.deposit(20);
        sa2.withdraw(30);
        System.out.println(sa2);

        CurrentAccount sa3 = new CurrentAccount(13);
        sa3.deposit(20);
        sa3.withdraw(40);
        System.out.println(sa3);

        Bank b = new Bank();
        b.accounts = new ArrayList<Account>();
        b.accounts.add(sa1);
        b.accounts.add(sa2);
        b.accounts.add(sa3);

        //actualizare
        System.out.println();
        b.actualizare(100);
        for (int i = 0; i < b.accounts.size(); i++) {
            System.out.println(b.accounts.get(i));
            //afsare conturi
        }
        CurrentAccount sa4 = new CurrentAccount(10);
        sa4.deposit(10);
        System.out.println(sa4);

        System.out.println("aici incepe primul accounts");
        b.deschidereCont(sa4);

        CurrentAccount sa5 = new CurrentAccount(15);
        sa5.deposit(20);
        System.out.println("aici incepe al doilea accounts");
        b.deschidereCont(sa5);

        for (int i = 0; i < b.accounts.size(); i++) {
            System.out.println(b.accounts.get(i));
        }

        CurrentAccount sa6=new CurrentAccount(15);
        sa6.deposit(10);
        System.out.println("Aici incepe testul de remove");
        b.inchidereCont(sa6);

        for (int i = 0; i < b.accounts.size(); i++) {
            System.out.println(b.accounts.get(i));
        }

        b.sortare();

        System.out.println("Suntem aici");
        for (int i = 0; i < b.accounts.size(); i++) {
            System.out.println(b.accounts.get(i));
        }
    }
}
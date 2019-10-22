package bank;

import java.util.ArrayList;
import java.util.Objects;

public class Account {

    protected double bal;
    protected int accnum;

    public Account(int a) {
        bal = 0.0;
        accnum = a;
    }

    public void deposit(double sum) {
        if (sum > 0)
            bal += sum;
        else
            System.err.println("Account.deposit(...): "
                    + "cannot deposit negative amount.");
    }

    public void withdraw(double sum) {
        if (sum > 0 && bal >= sum)
            bal -= sum;
        else
            System.err.println("Account.withdraw(...): "
                    + "cannot withdraw negative amount.");
    }

    public void transfer(Account from, double sum) {
        this.deposit(sum);
        from.withdraw(sum);
    }

    public void changeAccNr(Account a1) {
        int aux = this.accnum;
        this.accnum = a1.accnum;
        a1.accnum = aux;
    }

    public double getBalance() {
        return bal;
    }

    public double getAccountNumber() {
        return accnum;
    }

    public String toString() {
        return "Acc " + accnum + ": " + "balance = " + bal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accnum == account.accnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accnum);
    }

    public final void print() {
        System.out.println(toString());
    }

    public void setBalance(double bal) {
        this.bal = bal;
    }


}

package bank;

import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts;

    public void actualizare(double sum) {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).deposit(sum);
        }
    }

    public void deschidereCont(Account acc) {
        boolean found=false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accnum == acc.accnum) {
                found=true;
                System.out.println("Contul existent");
                break;
            }
            }
        if(!found){
            accounts.add(acc);
            System.out.println("Contul s.a adaugat");
        }
        System.out.println("Suntem aici");
    }

    int i;

    public void inchidereCont(Account acc){
        boolean found=false;
        for(i=0; i< accounts.size(); i++){

            if(accounts.get(i).accnum==acc.accnum){
                found=true;
                System.out.println("Contul exista");
                break;
            }
        }
        if(found){
            accounts.remove(i);
            System.out.println("contul a fost scos");
        }
    }

    public void sortare( ) {
        for (i = 0; i < this.accounts.size(); i++) {
            for (int j = 0; j < accounts.size(); j++) {
                if (accounts.get(i).bal > accounts.get(j).bal) {
                    Account aux = accounts.get(i);
                    accounts.set(i, accounts.get(j)) ;//accounts.get(i) = accounts.get(j);
                    accounts.set(j, aux);
                }
            }
        }
    }

    public void setAccounts(ArrayList<Account> acs){
       this.accounts=acs;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }
}
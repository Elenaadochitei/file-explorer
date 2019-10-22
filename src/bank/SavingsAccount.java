package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(int accnum) {
        super(accnum);
    }

    double interest = 0.25;

    public void deposit(double sum) {
        if (sum > 0)
            bal += sum +(interest*sum);
        else
            System.err.println("Fonduri insuficiente");
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String toString() {
        return super.toString()+ "interest= "+interest;
    }
}




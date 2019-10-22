package bank;

public class CurrentAccount extends Account {

    public CurrentAccount(int accnum){
        super(accnum);
    }

    double descoperire = -100.00;


    public void withdraw(double sum) {
        if (sum > 0) {
            if ((bal-sum) >= descoperire) {
                bal -= sum;
            } else {
                System.out.println("Am ajuns la limita de accounts");
            }
        } else {
            System.err.println("Suma invalida");
        }
    }

    public double getDescoperire() {
        return descoperire;
    }

    public void setDescoperire(double descoperire) {
        this.descoperire = descoperire;
    }

    public String toString() {
        return super.toString()+ "descoperire= "+descoperire;
    }
}

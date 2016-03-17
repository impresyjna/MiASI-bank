import java.util.Date;

public class DebitAccount extends Account implements Interest {
    private double interest;
    private double interestRate;
    private double limit;

    public DebitAccount(double limit, double interestRate) {
        this.limit = limit;
        this.startDate = new Date();
        this.balance = 0;
        this.open = true;
        this.interestRate = interestRate;
    }

    public double getInterest() {
        calculateInterest();
        return interest;
    }

    @Override
    public void calculateInterest() {
        if (this.balance < 0) {
            this.interest = (this.limit + this.balance) * interestRate;
        } else {
            this.interest = 0;
        }
    }

    @Override
    public boolean closeAccount() {
        if (this.balance == 0 && this.open) {
            this.open = false;
            return true;
        } else {
            return false;
        }
    }


}

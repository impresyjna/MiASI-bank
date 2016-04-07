
public class Loan implements Interest {
    private Account account;
    private double interest;
    private double interestPercent;
    private double balance;
    private CapitalizeType capitalizeType;

    public Loan(Account account, double interestPercent, double balance, CapitalizeType capitalizeType) {
        this.account = account;
        this.interestPercent = interestPercent;
        this.balance = balance;
        this.capitalizeType = capitalizeType;
    }

    @Override
    public void calculateInterest() {
        interest = balance * Math.pow((interestPercent / 100.0), 1.0);
        balance += interest;
    }

    public boolean payOffLoan(double instalment) {
        if (instalment > 0) {
            calculateInterest();
            balance -= instalment;
            return true;
        } else {
            return false;
        }
    }

    public double getInterest() {
        return interest;
    }

    public double getBalance() {
        return balance;
    }
}

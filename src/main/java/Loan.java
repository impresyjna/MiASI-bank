import java.util.Date;

public class Loan implements Interest {
    private Account account;
    private double interest;
    private double interestPercent;
    private double balance;
    private CapitalizeType capitalizeType;
    private Date startDate;

    public Loan(Account account, double interestPercent, double balance, CapitalizeType capitalizeType) {
        this.account = account;
        this.interestPercent = interestPercent;
        this.balance = balance;
        this.capitalizeType = capitalizeType;
        this.startDate = new Date(); 
    }

    @Override
    public void calculateInterest() {
        interest = balance * Math.pow(interestPercent / (100.0 * capitalizeType.getCapitalizeDivider()), capitalizeType.getCapitalizePower(startDate,new Date()));
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

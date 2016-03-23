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
            this.interest = -1 * this.balance * interestRate;
        } else {
            this.interest = 0;
        }
    }

    @Override
    public boolean minusMoney(double money, String description) {
        if (balance - money >= limit && money > 0) {
            Operation op = new Operation(money, new Date(), description, OperationType.MinusMoney, this, balance);
            balance -= money;
            operations.add(op);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean transferMoney(double money, Account account, String description) {
        if (money > 0 && account.isOpen() && balance - money >= limit) {
            executeTransferMoney(money,account,description);
            return true;
        } else {
            return false;
        }
    }

}

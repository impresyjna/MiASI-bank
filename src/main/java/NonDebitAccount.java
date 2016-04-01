import java.util.Date;

public class NonDebitAccount extends Account{
    private Bank bank = Bank.getInstance();

    public NonDebitAccount(){
        this.startDate = new Date();
        this.open = true;
        this.balance = 0;
        bank.addAccountToList(this);
        this.id = bank.getAccounts().lastIndexOf(this);
    }

    @Override
    public boolean minusMoney(double money, String description) {
        if (balance - money >= 0 && money > 0) {
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
        if (money > 0 && account.isOpen() && balance - money >= 0) {
            executeTransferMoney(money,account,description);
            return true;
        } else {
            return false;
        }
    }

}

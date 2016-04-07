import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected long ownerId;
    protected long id;
    protected Date startDate;
    protected double balance;
    protected List<Operation> operations = new ArrayList<>();
    protected boolean open;
    protected List<Deposit> deposits = new ArrayList<>();

    public abstract boolean minusMoney(double money, String description);

    public abstract boolean transferMoney(double money, Account account, String description);

    public boolean closeAccount() {
        if (this.balance == 0 && this.open) {
            this.open = false;
            return true;
        } else if (this.balance > 0 && this.open) {
            this.minusMoney(this.balance, "Close account. Client gets the money");
            this.open = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean addMoney(double money, String description) {
        if (money > 0) {
            Operation op = new Operation(money, new Date(), description, OperationType.AddMoney, this, balance);
            balance += money;
            operations.add(op);
            return true;
        } else {
            return false;
        }
    }

    public void executeTransferMoney(double money, Account account, String description) {
    	Operation op = new Operation(money, new Date(), description, OperationType.TransferMoneyMinus, this, balance);
        op.setSecondAccountForTransfer(account);
        operations.add(op);

        Operation op2 = new Operation(money, new Date(), description, OperationType.TransferMoneyPlus, account, account.getBalance());
        op2.setSecondAccountForTransfer(this);
        account.getOperations().add(op2);

        this.minusMoney(money, description);
        account.addMoney(money, description);
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addDeposit(Deposit deposit) {
    	this.deposits.add(deposit);
    }
    
    public boolean isOpen() {
        return open;
    }
}

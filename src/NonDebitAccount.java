import java.util.Date;

public class NonDebitAccount extends Account{

    public NonDebitAccount(){
        this.startDate = new Date();
        this.open = true;
        this.balance = 0;
    }

    @Override
    public boolean closeAccount() {
        if(this.balance==0 && this.open){
            this.open = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Operation addMoney(double money, String description) {
        Operation operation = new Operation(money, new Date(), description, OperationType.AddMoney, this);
        this.balance += money;
        return Operation;
    }

    @Override
    public Operation minusMoney(double money) {
        return null;
    }

    @Override
    public Operation transferMoney(double money, Account account) {
        return null;
    }
}

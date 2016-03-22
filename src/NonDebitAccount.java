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
    public boolean addMoney(double money, String description) {
        Operation operation = new Operation(money, new Date(), description, OperationType.AddMoney, this, balance);
        this.balance += money;
        return  true;
    }

    @Override
    public boolean minusMoney(double money, String description) {
        return false;
    }

    @Override
    public boolean transferMoney(double money, Account account, String description) {
        return true;
    }


}

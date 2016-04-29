package accounts;

import operations.Operation;
import operations.TransferForDebit;
import util.Bank;
import util.VisitorInterface;

/**
 * Created by impresyjna on 22.04.2016.
 */
public class AccountDecorator implements AccountInterface{
    private double limit;
    private double debit; //To jest dodatnia reprezentacja ujemnej wartości :D
    private Account account;
    private long id;

    public AccountDecorator(Account account, double limit, Bank bank) {
        this.account = account;
        this.limit = limit;
        this.debit = 0;
        bank.addAccountToList(this);
    }

    @Override
    //TODO: Dodać logi
    public boolean income(double amount) {
        if(debit>0){
            double tempValue = amount - debit;
            if(tempValue>0){
                debit = 0;
                account.income(tempValue);
                return true;
            } else if (tempValue==0) {
                debit = 0;
                return true;
            } else {
                debit -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    //TODO: LOGI
    public boolean substract(double amount) {
        if(account.getBalance()>=amount) {
            account.substract(amount);
            return true;
        } else if(account.getBalance()+this.limit - this.debit >= amount){
            account.substract(account.getBalance());
            double tempAmount = amount - account.getBalance();
            debit += tempAmount;
            return true;
        }
        return false;
    }

    @Override
    //TODO: LOGI
    public boolean transfer(Account to, double amount) {
        if(account.getBalance()>=amount) {
            account.transfer(to, amount);
            return true;
        } else if(account.getBalance()+this.limit - this.debit >= amount){
            double tempAmount = amount - account.getBalance();
            TransferForDebit operation = new TransferForDebit(account, to, amount, account.getBalance());
            account.doOperation(operation);
            debit += tempAmount;
            return true;
        }
        return false;
    }

    @Override
    public AccountInterface accept(VisitorInterface visitor) {
        return visitor.visit(this);
    }

    @Override
    public long getId() {
        return id;
    }
}

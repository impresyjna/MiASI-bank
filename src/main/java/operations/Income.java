package operations;

import accounts.Account;

/**
 * Created by impresyjna on 15.04.2016.
 */
public class Income extends Operation {
    private Account account;
    private double amount;

    public Income(Account account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        if(amount>0){
            account.setBalance(account.getBalance()+amount);
            return true;
        } else {
            return false;
        }
    }
}

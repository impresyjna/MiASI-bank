package operations;

import accounts.Account;

public class Substract extends Operation{
    private Account account;
    private double amount;

    public Substract(Account account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        if(amount>0 && (account.getBalance()-amount>=0)){
            account.setBalance(account.getBalance()-amount);
            return true;
        } else {
            return false;
        }
    }
}

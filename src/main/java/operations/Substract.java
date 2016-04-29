package operations;

import accounts.Account;

public class Substract extends Operation{
    private Account account;
    private double amount;

    public Substract(Account account, double amount){
        this.account = account;
        this.amount = amount;
    }

    //TODO: Zwrócić na to uwagę z tym >=0
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

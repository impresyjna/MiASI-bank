package util;

import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;

/**
 * Created by impresyjna on 29.04.2016.
 */
public class Over1000Report implements VisitorInterface{

    @Override
    public AccountInterface visit(Account account) {
        if(account.getBalance()>1000){
            return account;
        }
        return null;
    }

    @Override
    public AccountInterface visit(AccountDecorator accountDecorator) {
        return null;
    }
}

package util;

import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;

/**
 * Created by impresyjna on 29.04.2016.
 */
public class SumAllBalances implements VisitorInterface {

    @Override
    public Object visit(Account account) {
        return account.getBalance();
    }

    @Override
    public Object visit(AccountDecorator accountDecorator) {
        return accountDecorator.getBalance();
    }
}

package util;

import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;

/**
 * Created by impresyjna on 29.04.2016.
 */
public class PassAllReport implements VisitorInterface {

    @Override
    public AccountInterface visit(Account account) {
        return account;
    }

    @Override
    public AccountInterface visit(AccountDecorator accountDecorator) {
        return accountDecorator;
    }
}

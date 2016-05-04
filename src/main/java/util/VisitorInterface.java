package util;

import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;

/**
 * Created by impresyjna on 29.04.2016.
 */
public interface VisitorInterface {
    Object visit(Account account);
    Object visit(AccountDecorator accountDecorator);
}

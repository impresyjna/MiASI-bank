package util;

import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;

/**
 * Created by impresyjna on 29.04.2016.
 */
public interface VisitorInterface {
    Void visit(Account account);
    Void visit(AccountDecorator accountDecorator);
}

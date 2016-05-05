package operations;

import accounts.Account;
import accounts.AccountDecorator;

/**
 * Created by impresyjna on 05.05.2016.
 */
public class CloseForDebit extends CloseAccount{

    private AccountDecorator accountDecorator;
    public CloseForDebit(AccountDecorator accountDecorator) {
        super(accountDecorator.getAccount());
        this.accountDecorator = accountDecorator;
    }

    @Override
    public boolean execute(){
        if (accountDecorator.getDebit() == 0) {
            return accountDecorator.getAccount().doOperation(new CloseAccount(accountDecorator.getAccount()));
        } else {
            return false;
        }
    }
}

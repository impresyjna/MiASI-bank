package operations;

import accounts.Account;

/**
 * Created by impresyjna on 15.04.2016.
 */
public class CloseAccount extends Operation {
    private Account account;

    public CloseAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean execute() {
        if (account.getBalance() == 0 && account.isOpen()) {
            account.setOpen(false);
            return true;
        } else if (account.getBalance() > 0 && account.isOpen()) {
            account.doOperation(new Substract(account, account.getBalance()));
            account.setOpen(false);
            return true;
        } else {
            return false;
        }
    }
}

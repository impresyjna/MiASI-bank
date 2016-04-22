package operations;

import accounts.Account;

/**
 * Created by impresyjna on 15.04.2016.
 */
public class Transfer extends Operation {
    protected Account from;
    protected Account to;
    protected double amount;

    public Transfer(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        if (amount > 0 && from.isOpen() && to.isOpen() && (from.getBalance() - amount >= 0)) {
            if (from.doOperation(new Substract(from, amount))) {
                to.doOperation(new Income(to, amount));
                return true;
            }
        }
        return false;
    }
}

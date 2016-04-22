package operations;

import accounts.Account;

/**
 * Created by impresyjna on 22.04.2016.
 */
public class TransferForDebit extends Transfer {
    private double avaibleFunds;

    public TransferForDebit(Account from, Account to, double amount, double avaibleFunds) {
        super(from, to, amount);
        this.avaibleFunds = avaibleFunds;
    }

    @Override
    public boolean execute(){
        if (amount > 0 && from.isOpen() && to.isOpen() && (from.getBalance() - avaibleFunds >= 0)) {
            if (from.doOperation(new Substract(from, avaibleFunds))) {
                to.doOperation(new Income(to, amount));
                return true;
            }
        }
        return false;
    }
}

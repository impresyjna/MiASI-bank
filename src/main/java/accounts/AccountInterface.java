package accounts;

import util.VisitorInterface;

/**
 * Created by impresyjna on 22.04.2016.
 */
public interface AccountInterface {
    boolean income(double amount);
    boolean substract(double amount);
    boolean transfer(Account to, double amount);
    Void accept(VisitorInterface visitor);
    //TODO: Lepsze zwracanie obiektu z interfejsu
    long getId();
}

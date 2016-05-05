package operations;

import accounts.Account;
import accounts.AccountDecorator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import util.Bank;
import util.User;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 05.05.2016.
 */
public class CloseForDebitTest extends TestCase {
    private Account account;
    private AccountDecorator accountDecorator;
    private CloseForDebit operation;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, bank);
        accountDecorator = new AccountDecorator(account, 500, bank);
        operation = new CloseForDebit(accountDecorator);
    }

    public void testDebitZero() throws Exception {
        accountDecorator.substract(500);
        assertTrue(operation.execute());
    }

    public void testDebitNotPayedYet() throws Exception {
        accountDecorator.substract(1100);
        assertFalse(operation.execute());
    }

}
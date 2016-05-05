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
 * Created by impresyjna on 21.04.2016.
 */
public class CloseAccountTest extends TestCase {
    private Account account;
    private AccountDecorator accountDecorator;
    private CloseAccount operation;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, bank);
        accountDecorator = new AccountDecorator(account, 500, bank);
        operation = new CloseAccount(account);
    }

    public void testBalanceZeroAndAccountOpen() throws Exception {
        accountDecorator.substract(1000);
        assertTrue(operation.execute());
    }

    public void testAccountIsClose() throws Exception {
        account.setOpen(false);
        assertFalse(operation.execute());
    }

    public void testBalanceMoreThanZero() throws Exception {
        assertTrue(operation.execute());
    }

    public void testBalanceLessThanZero() throws Exception {
        accountDecorator.substract(1100);
        assertFalse(operation.execute());
    }
}
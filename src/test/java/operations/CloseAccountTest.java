package operations;

import accounts.Account;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import util.User;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 21.04.2016.
 */
public class CloseAccountTest extends TestCase {
    /* private Account account;
    private CloseAccount operation;

    @Before
    public void setUp() throws Exception {
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, -500);
        operation = new CloseAccount(account);
    }

    public void testBalanceZeroAndAccountOpen() throws Exception {
        account.setBalance(0);
        account.setOpen(true);
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
        account.setBalance(-100);
        assertFalse(operation.execute());
    } */
}
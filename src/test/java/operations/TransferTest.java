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
public class TransferTest extends TestCase {

    private Account from;
    private Account to;

    @Before
    public void setUp() throws Exception {
        User user = new User("Zbigniew", "Testowy");
        from = new Account(user, 1000, 0);
        to = new Account(user,1000,0);
    }

    public void testCorrectTransfer() throws Exception {
        Transfer operation = new Transfer(from,to,100);
        assertTrue(operation.execute());
    }

    public void testAmountEqualsZero() throws Exception {
        Transfer operation = new Transfer(from,to,0);
        assertFalse(operation.execute());
    }

    public void testFromAccountIsClosed() throws Exception {
        Transfer operation = new Transfer(from,to,100);
        from.setOpen(false);
        assertFalse(operation.execute());
    }

    public void testToAccountIsClosed() throws Exception {
        Transfer operation = new Transfer(from,to,100);
        to.setOpen(false);
        assertFalse(operation.execute());
    }

    public void testAmountMoreThanBalanceInFrom() throws Exception {
        Transfer operation = new Transfer(from,to,1100);
        assertFalse(operation.execute());
    }

}
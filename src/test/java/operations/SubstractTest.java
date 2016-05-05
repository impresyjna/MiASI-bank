package operations;

import accounts.Account;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import util.Bank;
import util.Mediator;
import util.User;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 21.04.2016.
 */
public class SubstractTest extends TestCase {
    private Account account;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank(new Mediator(),"00000001");
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, bank);
    }

    public void testAmountEqualsZero() throws Exception {
        Substract operation = new Substract(account, 0);
        assertFalse(operation.execute());
    }

    public void testSubstractMoreThanBalance() throws Exception {
        Substract operation = new Substract(account, 1100);
        assertFalse(operation.execute());
    }

    public void testCorrectSubstract() throws Exception {
        Substract operation = new Substract(account, 100);
        assertTrue(operation.execute());
        assertTrue(account.getBalance() == 900);
    }

}
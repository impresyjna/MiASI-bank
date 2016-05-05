package operations;

import accounts.Account;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import util.Bank;
import util.User;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 21.04.2016.
 */
public class IncomeTest extends TestCase {
    private Account account;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, bank);
    }

    public void testAmountEqualsZero() throws Exception {
        Income operation = new Income(account, 0);
        assertFalse(operation.execute());
    }

    public void testCorrectIncomeOperation() throws Exception {
        Income operation = new Income(account, 100);
        assertTrue(operation.execute());
        assertTrue(account.getBalance() == 1100);
    }
}
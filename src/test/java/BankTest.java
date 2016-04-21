import accounts.Account;
import junit.framework.TestCase;
import org.junit.Before;
import util.Bank;
import util.User;

/**
 * Created by impresyjna on 01.04.2016.
 */
public class BankTest extends TestCase {
    private Account account;
    private User user;
    private Bank bank;

    @Before
    protected void setUp() throws Exception {
        user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, -500);
        bank = new Bank();
    }

    public void testIncome() throws Exception {
        assertTrue(bank.income(account, 500));
        assertTrue(account.getBalance()==1500);
    }

    public void testSubstractInLimit() throws Exception {
        assertTrue(bank.substract(account,500));
        assertTrue(account.getBalance()==500);
    }

    public void testSubstractOutOfLimit() throws Exception {
        assertFalse(bank.substract(account,1600));
    }

    public void testTransferInPlus() throws Exception {
        Account accountTo = new Account(user, 1000, 0);
        assertTrue(bank.transfer(account, accountTo, 500));
        assertTrue(account.getBalance()==500);
        assertTrue(accountTo.getBalance()==1500);
    }

    public void testTransferWithoutEnoughMoney() throws Exception {
        Account accountTo = new Account(user, 1000, 0);
        assertFalse(bank.transfer(account,accountTo,1600));
    }
}
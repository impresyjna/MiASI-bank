import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Before;

/**
 * Created by impresyjna on 01.04.2016.
 */
public class BankTest extends TestCase {
    private Bank bank = Bank.getInstance();
    private User user;

    @Before
    protected void setUp() throws Exception {
        user = new User("Test", "Testowy"); 
    }

    public void testAddUserToList() throws Exception {
        User user = new User("Test", "Testowy");
        User user1 = new User("Testowy", "Test");
        assertFalse(bank.getUsers().isEmpty());
        assertTrue(bank.getUsers().size()>0);
        assertTrue(user.getId() == 0);
        assertTrue(user1.getId() == 1);
    }

    public void testAddAccountToList() throws Exception {
        NonDebitAccount nonDebitAccount = new NonDebitAccount(user);
        NonDebitAccount nonDebitAccount1 = new NonDebitAccount(user);
        assertFalse(bank.getAccounts().isEmpty());
        assertTrue(bank.getAccounts().size()>0);
    }
}
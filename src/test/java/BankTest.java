import junit.framework.TestCase;

/**
 * Created by impresyjna on 01.04.2016.
 */
public class BankTest extends TestCase {
    private Bank bank = Bank.getInstance();


    public void testAddUserToList() throws Exception {
        User user = new User("Test", "Testowy");
        User user1 = new User("Testowy", "Test");
        assertFalse(bank.getUsers().isEmpty());
        assertTrue(bank.getUsers().size()==2);
        assertTrue(user.getId() == 0);
        assertTrue(user1.getId() == 1);
    }

    public void testAddAccountToList() throws Exception {
        NonDebitAccount nonDebitAccount = new NonDebitAccount();
        NonDebitAccount nonDebitAccount1 = new NonDebitAccount();
        assertFalse(bank.getAccounts().isEmpty());
        assertTrue(bank.getAccounts().size()==2);
        assertTrue(nonDebitAccount.id == 0);
        assertTrue(nonDebitAccount1.id == 1);
    }
}
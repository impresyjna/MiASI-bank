import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import util.User;

/**
 * Created by marci on 23.03.2016.
 */
public class NonDebitAccountTest extends TestCase {
    private User user;

    /* @Before
    protected void setUp() throws Exception {
        user = new User("Test", "Testowy");
    }

    public void testMinusMoney_overLimit() throws Exception {
        NonDebitAccount nda = new NonDebitAccount(user);
        assertFalse(nda.minusMoney(1000,""));
    }

    public void testMinusMoney_negativeMoney() throws Exception {
        NonDebitAccount nda = new NonDebitAccount(user);
        nda.addMoney(1000,"");
        assertFalse(nda.minusMoney(-500,""));
    }

    @Test
    public void testMinusMoney_ok() throws Exception {
        NonDebitAccount nda = new NonDebitAccount(user);
        nda.addMoney(1000, "");
        nda.minusMoney(500, "");
        assertTrue(nda.getBalance()==500);
        assertTrue(nda.getOperations().size()>1);
        assertTrue(nda.getOperations().get(1).getBalance() == 500);
        assertTrue(nda.getOperations().get(1).getType() == OperationType.MinusMoney);
        assertTrue(nda.getOperations().get(1).getOldBalance() == 1000);
    }

    public void testTransferMoney_negativeMoney() throws Exception {
        NonDebitAccount nda1 = new NonDebitAccount(user);
        NonDebitAccount nda2 = new NonDebitAccount(user);
        assertFalse(nda1.transferMoney(-5,nda2,""));
    }

    public void testTransferMoney_closeAccount() throws Exception {
        NonDebitAccount nda1 = new NonDebitAccount(user);
        NonDebitAccount nda2 = new NonDebitAccount(user);
        nda2.closeAccount();
        assertFalse(nda1.transferMoney(5,nda2,""));
    }

    public void testTransferMoney_overLimit() throws Exception {
        NonDebitAccount nda1 = new NonDebitAccount(user);
        NonDebitAccount nda2 = new NonDebitAccount(user);
        assertFalse(nda1.transferMoney(600,nda2,""));
    }

    public void testTransferMoney_ok() throws Exception {
        NonDebitAccount nda1 = new NonDebitAccount(user);
        NonDebitAccount nda2 = new NonDebitAccount(user);
        nda1.addMoney(1000,"");
        assertTrue(nda1.transferMoney(400,nda2,""));
        assertTrue(nda1.getBalance()==600);
        assertTrue(nda2.getBalance()==400);

        assertTrue(nda1.getOperations().size()>1);
        assertTrue(nda1.getOperations().get(1).getType() == OperationType.TransferMoneyMinus);
        assertTrue(nda1.getOperations().get(1).getBalance() == 400);
        assertTrue(nda1.getOperations().get(1).getOldBalance() == 1000);

        assertTrue(nda2.getOperations().size()>0);
        assertTrue(nda2.getOperations().get(0).getType() == OperationType.TransferMoneyPlus);
        assertTrue(nda2.getOperations().get(0).getBalance() == 400);
        assertTrue(nda2.getOperations().get(0).getOldBalance() == 0);
    } */
}
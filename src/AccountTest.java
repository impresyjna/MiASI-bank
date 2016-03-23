import junit.framework.TestCase;

/**
 * Created by marci on 23.03.2016.
 */
public class AccountTest extends TestCase {

    public void testCloseAccount_negativeBalance() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.minusMoney(200,"");
        assertFalse(da.closeAccount());
    }

    public void testCloseAccount_ok() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.minusMoney(200,"");
        da.addMoney(200,"");
        assertTrue(da.closeAccount());
    }

    public void testAddMoney_ok() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.addMoney(500,"");
        assertTrue(da.getBalance()==500);
        assertTrue(da.getOperations().size()>0);
        assertTrue(da.getOperations().get(0).getBalance() == 500);
        assertTrue(da.getOperations().get(0).getType() == OperationType.AddMoney);
        assertTrue(da.getOperations().get(0).getOldBalance() == 0);
    }

    public void testAddMoney_negativeMoney() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        assertFalse(da.addMoney(-500,""));
    }
}
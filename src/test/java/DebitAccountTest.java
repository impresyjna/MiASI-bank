import org.junit.Before;

import junit.framework.TestCase;

/**
 * Created by inf109754 on 2016-03-18.
 */
public class DebitAccountTest extends TestCase {

	DebitAccount da;
    
    @Before
    public void setUp() {
    	da = new DebitAccount(-500,0.5, new User("",""));
    }
	
    public void testCalculateInterest_negativeBalance() throws Exception {
        assertTrue(da.getInterest()==0);
    }

    public void testCalculateInterest_ok() throws Exception {
        da.minusMoney(200,"");  //balance
        assertTrue(da.getInterest()==100);
    }

    public void testMinusMoney_overLimit() throws Exception {
        assertFalse(da.minusMoney(1000,""));
    }

    public void testMinusMoney_negativeMoney() throws Exception {
        assertFalse(da.minusMoney(-500,""));
    }

    public void testMinusMoney_ok() throws Exception {
        da.minusMoney(500,"");
        assertTrue(da.getBalance()==-500);
        assertTrue(da.getOperations().size()>0);
        assertTrue(da.getOperations().get(0).getBalance() == 500);
        assertTrue(da.getOperations().get(0).getType() == OperationType.MinusMoney);
        assertTrue(da.getOperations().get(0).getOldBalance() == 0);
    }

    public void testTransferMoney_negativeMoney() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5, new User("",""));
        DebitAccount da2 = new DebitAccount(-500,0.5, new User("",""));
        assertFalse(da1.transferMoney(-5,da2,""));
    }

    public void testTransferMoney_closeAccount() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5, new User("",""));
        DebitAccount da2 = new DebitAccount(0,0.5, new User("",""));
        da2.closeAccount();
        assertFalse(da1.transferMoney(5,da2,""));
    }

    public void testTransferMoney_overLimit() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5, new User("","")); //limit=-500
        DebitAccount da2 = new DebitAccount(0,0.5, new User("",""));
        assertFalse(da1.transferMoney(600,da2,""));
    }

    public void testTransferMoney_ok() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5, new User("",""));
        DebitAccount da2 = new DebitAccount(-100,0.5, new User("",""));
        assertTrue(da1.transferMoney(400,da2,""));
        assertTrue(da1.getBalance()==-400);
        assertTrue(da2.getBalance()==400);

        assertTrue(da1.getOperations().size()>0);
        assertTrue(da1.getOperations().get(0).getType() == OperationType.TransferMoneyMinus);
        assertTrue(da1.getOperations().get(0).getBalance() == 400);
        assertTrue(da1.getOperations().get(0).getOldBalance() == 0);

        assertTrue(da2.getOperations().size()>0);
        assertTrue(da2.getOperations().get(0).getType() == OperationType.TransferMoneyPlus);
        assertTrue(da2.getOperations().get(0).getBalance() == 400);
        assertTrue(da2.getOperations().get(0).getOldBalance() == 0);
    }

}
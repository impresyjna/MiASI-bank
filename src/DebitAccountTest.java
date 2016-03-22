import junit.framework.TestCase;

/**
 * Created by inf109754 on 2016-03-18.
 */
public class DebitAccountTest extends TestCase {


    public void testCalculateInterest1() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        assertTrue(da.getInterest()==0);
    }

    public void testCalculateInterest2() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);   //limit
        da.minusMoney(200,"");  //balance
        assertTrue(da.getInterest()==100);
    }

    public void testCloseAccount1() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.minusMoney(200,"");
        assertFalse(da.closeAccount());
    }

    public void testCloseAccount2() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.minusMoney(200,"");
        da.addMoney(200,"");
        assertTrue(da.closeAccount());
    }

    public void testAddMoney1() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        da.addMoney(500,"");
        assertTrue(da.getBalance()==500);
        if(da.getOperations().size()>0) {
            assertTrue(da.getOperations().get(0).getBalance() == 500);
            assertTrue(da.getOperations().get(0).getType() == OperationType.AddMoney);
            assertTrue(da.getOperations().get(0).getOldBalance() == 0);
        }else{
            assertFalse(true);
        }
    }

    public void testAddMoney2() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        assertFalse(da.addMoney(-500,""));
    }

    public void testMinusMoney1() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        assertFalse(da.minusMoney(1000,""));
    }

    public void testMinusMoney2() throws Exception {
        DebitAccount da = new DebitAccount(-500,0.5);
        assertFalse(da.minusMoney(-500,""));
    }

    public void testMinusMoney3() throws Exception {
        //TODO: Rozbić na dwa testCase
        DebitAccount da = new DebitAccount(-500,0.5);
        da.minusMoney(500,"");
        assertTrue(da.getBalance()==-500);
        if(da.getOperations().size()>0) {
            assertTrue(da.getOperations().get(0).getBalance() == 500);
            assertTrue(da.getOperations().get(0).getType() == OperationType.MinusMoney);
            assertTrue(da.getOperations().get(0).getOldBalance() == 0);
        }else{
            fail();
        }
    }

    public void testTransferMoney1() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5);
        DebitAccount da2 = new DebitAccount(-500,0.5);
        assertFalse(da1.transferMoney(-5,da2,""));
    }

    public void testTransferMoney2() throws Exception {
        DebitAccount da1 = new DebitAccount(-500,0.5);
        DebitAccount da2 = new DebitAccount(0,0.5);
        da2.closeAccount();
        assertFalse(da1.transferMoney(5,da2,""));   //TODO dokończyć
    }

}
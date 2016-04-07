import junit.framework.TestCase;


import java.util.ArrayList;

import org.easymock.EasyMock;

/**
 * Created by marci on 23.03.2016.
 */
public class AccountTest extends TestCase {
	
    Account account;
    
    public void setUp() {
    	account = EasyMock.createMock(Account.class);
    }
    
    public void testCase() {
    	DebitAccount da = new DebitAccount(-1000.0, 0.5);
    	
    	EasyMock.expect(account.getBalance()).andReturn(0.0);
    	EasyMock.expect(account.getOperations()).andReturn(new ArrayList<Operation>());
    	EasyMock.expect(account.addMoney(50.0,"")).andReturn(true);
    	
    	EasyMock.replay(account);
    	
    	da.executeTransferMoney(50, account, "");
    	assertTrue(da.getBalance()==-50);
    	
    	EasyMock.verify();   	
    }
    
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

    public void testCloseAccountWithPlusBalance_ok() throws Exception {
        DebitAccount da = new DebitAccount(-500, 0.5);
        da.addMoney(500, "Add money");
        assertTrue(da.closeAccount());
        assertTrue(da.getOperations().size()==2);
        assertTrue(da.balance==0);
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
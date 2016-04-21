import accounts.Account;
import junit.framework.TestCase;


import java.util.ArrayList;

import operations.Income;
import operations.Operation;
import operations.Substract;
import org.easymock.EasyMock;
import org.junit.Before;
import util.User;

/**
 * Created by marci on 23.03.2016.
 */
public class AccountTest extends TestCase {
	
    Account account;
    
    @Before
    public void setUp() {
    	//account = EasyMock.createMock(Account.class);
        User user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, 0);
    }

    public void testDoCorrectOperation() throws Exception {
        assertTrue(account.doOperation(new Income(account,100)));
        assertFalse(account.getHistory().getOperationList().isEmpty());
    }

    public void testDoIncorrectOperation() throws Exception {
        assertFalse(account.doOperation(new Substract(account,1100)));
        assertTrue(account.getHistory().getOperationList().isEmpty());
    }
   
}
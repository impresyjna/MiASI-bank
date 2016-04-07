
import java.util.Date;

import org.junit.Before;

import junit.framework.TestCase;


public class DepositTest extends TestCase{

	DebitAccount da;
    
    @Before
    public void setUp() {
    	da = new DebitAccount(-500,0.5, new User("",""));
    }
	
	public void testCanNotCreate()	{
		try {
			Deposit deposit = Deposit.createDeposit(5000, 0.5, new Date(), da);
			deposit.calculateInterest();
			fail();
		} catch(NotEnoughMoneyException ex) {
		}
	}
	
	public void testCalculateInterest()	{
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, new Date(), da);
			deposit.calculateInterest();
			assertTrue(deposit.getInterest()==250);
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
	
	public void testCloseAccount_afterEnd() {
		Date date = new Date();
		date.setTime(date.getTime()-100000);
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, date, da);
			assertTrue(deposit.closeAccount());
			assertTrue(da.getBalance()==250);
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
	
	public void testCloseAccount_beforeEnd() {
		Date date = new Date();
		date.setTime(date.getTime()+100000);
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, date, da);
			assertTrue(deposit.closeAccount());
			assertTrue(da.getBalance()==0);
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
	
	public void testCloseAccount_secendClose() { 
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, new Date(), da);
			deposit.closeAccount();
			assertFalse(deposit.closeAccount());
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
}

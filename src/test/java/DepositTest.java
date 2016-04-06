
import java.util.Date;

import junit.framework.TestCase;


public class DepositTest extends TestCase{

	public void testCanNotCreate()	{
		DebitAccount da = new DebitAccount(-500,0.5);   //limit
		try {
			Deposit deposit = Deposit.createDeposit(5000, 0.5, new Date(), da);
			deposit.calculateInterest();
			assertFalse(deposit.getInterest()==2500);
		} catch(NotEnoughMoneyException ex) {
			assertTrue(da.getDeposits().isEmpty());
		}
	}
	
	public void testCalculateInterest()	{
		DebitAccount da = new DebitAccount(-500,0.5);  
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, new Date(), da);
			deposit.calculateInterest();
			assertTrue(deposit.getInterest()==250);
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
	
	public void testCloseAccount_afterEnd() {
		DebitAccount da = new DebitAccount(-500,0.5); 
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
		DebitAccount da = new DebitAccount(-500,0.5); 
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
		DebitAccount da = new DebitAccount(-500,0.5); 
		try {
			Deposit deposit = Deposit.createDeposit(500, 0.5, new Date(), da);
			deposit.closeAccount();
			assertFalse(deposit.closeAccount());
		} catch(NotEnoughMoneyException ex) {
			fail();
		}
	}
}

package accounts;

import junit.framework.TestCase;
import operations.TransferForDebit;
import org.junit.Before;
import org.junit.Test;
import util.Bank;
import util.Mediator;
import util.User;
import util.VisitorInterface;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 05.05.2016.
 */
public class AccountDecoratorTest extends TestCase {

    AccountDecorator accountDecorator;
    Account to;

    @Before
    public void setUp() {
        Bank bank = new Bank(new Mediator(),"00000001");
        User user = new User("Zbigniew", "Testowy");
        Account account = new Account(user, 0, bank);
        to = new Account(user, 1000, bank);
        accountDecorator = new AccountDecorator(account,500,bank);
    }

    public void testDebitMoreThanZero() throws Exception {
        accountDecorator.setDebit(100);
        assertTrue(accountDecorator.income(200));
        assertTrue(accountDecorator.getDebit()==0);
        assertTrue(accountDecorator.getAccount().getBalance()==100);
    }

    public void testDebitMoreThanZeroAndPayOffDebit() throws Exception {
        accountDecorator.setDebit(100);
        assertTrue(accountDecorator.income(100));
        assertTrue(accountDecorator.getDebit()==0);
        assertTrue(accountDecorator.getAccount().getBalance()==0);
    }

    public void testDebitMoreThanZeroAndPayPartOfDebit() throws Exception {
        accountDecorator.setDebit(100);
        assertTrue(accountDecorator.income(50));
        assertTrue(accountDecorator.getDebit()==50);
        assertTrue(accountDecorator.getAccount().getBalance()==0);
    }

    public void testAmountLessThanZeroForIncome() throws Exception {
        accountDecorator.setDebit(100);
        assertFalse(accountDecorator.income(-100));
    }

    public void testBalanceIsMoreOrEqualThanAmount() throws Exception {
        accountDecorator.getAccount().setBalance(200);
        assertTrue(accountDecorator.substract(200));
        assertTrue(accountDecorator.getAccount().getBalance()==0);
        assertTrue(accountDecorator.getDebit()==0);
    }

    public void testBalanceIsLessThanAmountAndDebitFits() throws Exception {
        accountDecorator.getAccount().setBalance(200);
        assertTrue(accountDecorator.substract(500));
        assertTrue(accountDecorator.getDebit()==300);
        assertTrue(accountDecorator.getAccount().getBalance()==0);
    }

    public void testSubstractMoreThanPossible() throws Exception {
        accountDecorator.getAccount().setBalance(200);
        assertFalse(accountDecorator.substract(1000));
    }

    public void testAmountLessThanZeroForSubstract() throws Exception {
        assertFalse(accountDecorator.substract(-100));
    }

    public void testTransferForAmountLessOrEqualThanBalance() throws Exception {
        accountDecorator.getAccount().setBalance(500);
        assertTrue(accountDecorator.transfer(to,500));
        assertTrue(accountDecorator.getAccount().getBalance()==0);
        assertTrue(to.getBalance()==1500);
        assertTrue(accountDecorator.getDebit()==0);
    }

    public void testTransferForAmountMoreThanBalanceButStillInLimit() throws Exception {
        assertTrue(accountDecorator.transfer(to,300));
        assertTrue(accountDecorator.getDebit()==300);
        assertTrue(accountDecorator.getAccount().getBalance()==0);
        assertTrue(to.getBalance()==1300);
    }

    public void testTransferForMoreThanLimit() throws Exception {
        assertFalse(accountDecorator.transfer(to,1000));
        assertTrue(to.getBalance()==1000);
        assertTrue(accountDecorator.getDebit()==0);
    }

    public void testTransferWithAmountLessThanZero() throws Exception {
        assertFalse(accountDecorator.transfer(to,-1000));
    }
}
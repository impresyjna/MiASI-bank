import accounts.Account;
import accounts.AccountDecorator;
import accounts.AccountInterface;
import junit.framework.TestCase;
import org.junit.Before;
import util.*;

import java.util.List;

/**
 * Created by impresyjna on 01.04.2016.
 */
public class BankTest extends TestCase {
    private Bank bank;

    @Before
    protected void setUp() throws Exception {
        bank = new Bank();
    }

    public void testPassAllReportDoReport() throws Exception {
        User user = new User("Zbigniew", "Testowy");
        Account account = new Account(user, 1100, bank);
        Account account1 = new Account(user, 500, bank);
        AccountDecorator accountDecorator = new AccountDecorator(account, 100, bank);
        List<AccountInterface> accounts = bank.doReport(new PassAllReport());
        assertTrue(accounts.size()==3);
    }

    public void testOver1000ReportDoReport() throws Exception {
        User user = new User("Zbigniew", "Testowy");
        Account account = new Account(user, 1100, bank);
        Account account1 = new Account(user, 500, bank);
        AccountDecorator accountDecorator = new AccountDecorator(account, 100, bank);
        List<AccountInterface> accounts = bank.doReport(new Over1000Report());
        assertTrue(accounts.size()==1);
    }

    public void testSumAllBalancesDoReport() throws Exception {
        User user = new User("Zbigniew", "Testowy");
        Account account = new Account(user, 1100, bank);
        Account account1 = new Account(user, 500, bank);
        AccountDecorator accountDecorator = new AccountDecorator(account, 100, bank);
        double sumBalances = bank.doSumReport(new SumAllBalances());
        assertTrue(sumBalances==1600)
        ;
    }
    /* private Account account;
    private User user;
    private Bank bank;

    @Before
    protected void setUp() throws Exception {
        user = new User("Zbigniew", "Testowy");
        account = new Account(user, 1000, -500);
        bank = new Bank();
    }

    public void testIncome() throws Exception {
        assertTrue(bank.income(account, 500));
        assertTrue(account.getBalance()==1500);
    }

    public void testSubstractInLimit() throws Exception {
        assertTrue(bank.substract(account,500));
        assertTrue(account.getBalance()==500);
    }

    public void testSubstractOutOfLimit() throws Exception {
        assertFalse(bank.substract(account,1600));
    }

    public void testTransferInPlus() throws Exception {
        Account accountTo = new Account(user, 1000, 0);
        assertTrue(bank.transfer(account, accountTo, 500));
        assertTrue(account.getBalance()==500);
        assertTrue(accountTo.getBalance()==1500);
    }

    public void testTransferWithoutEnoughMoney() throws Exception {
        Account accountTo = new Account(user, 1000, 0);
        assertFalse(bank.transfer(account,accountTo,1600));
    } */
}
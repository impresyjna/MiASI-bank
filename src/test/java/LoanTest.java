import accounts.Loan;
import enums.CapitalizeType;
import org.junit.Test;
import util.User;

import static org.junit.Assert.*;

/**
 * Created by impresyjna on 07.04.2016.
 */
public class LoanTest {

    /* @Test
    public void testCalculateInterest() throws Exception {
        User user = new User("Test", "Testowy");
        NonDebitAccount nonDebitAccount = new NonDebitAccount(user);
        Loan loan = new Loan(nonDebitAccount, 5, 1000, CapitalizeType.Yearly);
        loan.calculateInterest();
        assertTrue(loan.getInterest()==50);
    }

    @Test
    public void testPayOffLoan_correct() throws Exception {
        User user = new User("Test", "Testowy");
        NonDebitAccount nonDebitAccount = new NonDebitAccount(user);
        Loan loan = new Loan(nonDebitAccount, 5, 1000, CapitalizeType.Yearly);
        assertTrue(loan.payOffLoan(100));
        assertTrue(loan.getBalance()==950);
        assertTrue(loan.getInterest()==50);
    }

    @Test
    public void testPayOffLoan_incorrect() throws Exception {
        User user = new User("Test", "Testowy");
        NonDebitAccount nonDebitAccount = new NonDebitAccount(user);
        Loan loan = new Loan(nonDebitAccount, 5, 1000, CapitalizeType.Yearly);
        assertFalse(loan.payOffLoan(-100));
    } */
}
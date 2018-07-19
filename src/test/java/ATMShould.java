import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ATMShould {

    private TestableTransactionController testableTransactionController;
    private ATM atm;
    private ClockFormatter clockFormatter = mock(ClockFormatter.class);
    private Console printer = mock(Console.class);

    @Before
    public void setup() {
        testableTransactionController = new TestableTransactionController();
        atm = new ATM(printer, testableTransactionController, clockFormatter);
    }

    @Test
    public void deposit_money() {
        atm.deposit(new Money(500));

        List<Transaction> transactions = testableTransactionController.getTransactions().toList();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0).amount(), is(500.0));
        assertThat(transactions.get(0).type(), is(TransactionType.DEPOSIT));
    }

    @Test
    public void withdraw_money() {
        atm.withdraw(new Money(100));

        List<Transaction> transactions = testableTransactionController.getTransactions().toList();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0).amount(), is(100.0));
        assertThat(transactions.get(0).type(), is(TransactionType.WITHDRAW));
    }

    @Test
    public void print_statement() {
        when(clockFormatter.getDateAsString(any())).thenReturn("10/01/2012", "13/01/2012", "14/01/2012" );

        atm.deposit(new Money(10));
        atm.deposit(new Money(20));
        atm.withdraw(new Money(5));

        atm.print();

        verify(printer).print("date || credit || debit || balance\n" +
                "14/01/2012 || || 5.00 || 25.00\n" +
                "13/01/2012 || 20.00 || || 30.00\n" +
                "10/01/2012 || 10.00 || || 10.00");
    }

    private class TestableTransactionController extends TransactionController {

        private Transactions transactions = new Transactions();

        @Override
        public void add(Transaction transaction) {
            this.transactions.add(transaction);
        }

        @Override
        public Transactions getTransactions() {
            return this.transactions;
        }
    }
}

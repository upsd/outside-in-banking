import com.sun.javafx.UnmodifiableArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransactionsShould {

    private TestableTransactions transactions;

    @Before
    public void setup() {
        transactions = new TestableTransactions();
    }

    @Test
    public void add_transaction() {
        transactions.add(new Transaction(null, null, null));

        assertThat(transactions.getAll().size(), is(1));
    }

    @Test
    public void be_empty_when_first_created() {
        assertThat(transactions.getAll().size(), is(0));
    }

    @Test
    public void print_transactions() {
        StatementFormatter statementFormatter = mock(StatementFormatter.class);
        Console printer = mock(Console.class);

        transactions.print(printer, statementFormatter, new ClockFormatter());

        verify(statementFormatter).formatUsing(any(), any());
        verify(printer).print(any());
    }

    private class TestableTransactions extends Transactions {

        private List<Transaction> transactions = new ArrayList<>();

        @Override
        public void add(Transaction transaction) {
            this.transactions.add(transaction);
        }

        public List<Transaction> getAll() {
            return Collections.unmodifiableList(this.transactions);
        }
    }
}

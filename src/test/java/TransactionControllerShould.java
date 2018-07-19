import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransactionControllerShould {

    private TransactionController controller;

    @Before
    public void setup() {
        controller = new TransactionController();
    }

    @Test
    public void has_no_transactions_by_default() {
        List<Transaction> transactions = controller.getTransactions().toList();

        assertThat(transactions.size(), is(0));
    }

    @Test
    public void add_transactions() {
        controller.add(new Transaction(new Money(100), TransactionType.WITHDRAW, LocalDate.of(2018, 10, 12)));

        List<Transaction> transactions = controller.getTransactions().toList();

        assertThat(transactions.size(), is(1));
    }
}

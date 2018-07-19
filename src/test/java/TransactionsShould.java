import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransactionsShould {

    private Transactions transactions;

    @Before
    public void setup() {
        transactions = new Transactions();
    }

    @Test
    public void add_transaction() {
        transactions.add(new Transaction(null, null, null));

        assertThat(transactions.toList().size(), is(1));
    }

    @Test
    public void be_empty_when_first_created() {
        assertThat(transactions.toList().size(), is(0));
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransactionControllerShould {

    private Transactions transactions = mock(Transactions.class);
    private TransactionController controller;

    @Before
    public void setup() {
        controller = new TransactionController(transactions);
    }

    @Test
    public void add_transaction() {
        controller.add(null);

        verify(transactions).add(any());
    }

    @Test
    public void print_transactions() {
        controller.print(null, null);

        verify(transactions).print(any(), any(), any());
    }
}

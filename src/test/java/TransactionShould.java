import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransactionShould {

    Transaction transaction = new Transaction(
            new Money(new BigDecimal(50.50)),
            TransactionType.DEPOSIT,
            LocalDate.of(2018, 10, 12)
    );

    @Test
    public void return_transaction_amount() {
        assertThat(transaction.amount(), is(50.50));
    }

    @Test
    public void return_transaction_type() {
        assertThat(transaction.type(), is(TransactionType.DEPOSIT));
    }

    @Test
    public void return_transaction_date() {
        assertThat(transaction.date(), is(LocalDate.of(2018, 10, 12)));
    }
}

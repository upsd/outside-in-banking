import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StatementFormatterShould {
    
    @Test
    public void format_statement_from_list_of_transactions() {
        Transactions transactions = new Transactions();
        transactions.add(new Transaction(new Money(new BigDecimal(20)), TransactionType.DEPOSIT, LocalDate.of(2018, 10, 12)));
        transactions.add(new Transaction(new Money(new BigDecimal(15)), TransactionType.DEPOSIT, LocalDate.of(2018, 10, 15)));
        transactions.add(new Transaction(new Money(new BigDecimal(10)), TransactionType.WITHDRAW, LocalDate.of(2018, 10, 20)));

        StatementFormatter formatter = new StatementFormatter();
//        String statement = formatter.formatUsing(transactions, new ClockFormatter());

//        assertThat(statement, is("date || credit || debit || balance\n" +
//                "20/10/2018 || || 10.00 || 25.00\n" +
//                "15/10/2018 || 15.00 || || 35.00\n" +
//                "12/10/2018 || 20.00 || || 20.00"));
    }
}

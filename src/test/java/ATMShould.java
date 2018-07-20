import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class ATMShould {

    private TransactionController transactionController;
    private ATM atm;
    private ClockFormatter clockFormatter = mock(ClockFormatter.class);
    private Console printer = mock(Console.class);

    @Before
    public void setup() {
        transactionController = mock(TransactionController.class);
        atm = new ATM(printer, transactionController, clockFormatter);
    }

    @Test
    public void deposit_money() {
        when(clockFormatter.getDateAsString(any())).thenReturn("10/01/2012");

        atm.deposit(new Money(new BigDecimal(500)));

        verify(transactionController).add(any());
    }

    @Test
    public void withdraw_money() {
        when(clockFormatter.getDateAsString(any())).thenReturn("10/01/2012");

        atm.withdraw(new Money(new BigDecimal(100)));

        verify(transactionController).add(any());
    }

    @Test
    public void print_statement() {
        when(clockFormatter.getDateAsString(any())).thenReturn("10/01/2012", "13/01/2012", "14/01/2012" );

        atm.deposit(new Money(new BigDecimal(10)));
        atm.deposit(new Money(new BigDecimal(20)));
        atm.withdraw(new Money(new BigDecimal(5)));

        atm.print();

        verify(transactionController).print(printer, clockFormatter);
    }
}

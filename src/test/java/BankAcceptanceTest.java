import org.junit.Test;

import static org.mockito.Mockito.*;

public class BankAcceptanceTest {
    
    @Test
    public void should_print_statement_after_performing_transactions() {
        Console printer = mock(Console.class);
        ClockFormatter clockFormatter = mock(ClockFormatter.class);
        ATM atm = new ATM(printer, new TransactionController(), clockFormatter);

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
}

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoneyShould {
    
    @Test
    public void return_as_double() {
        Money money = new Money(new BigDecimal(23));

        assertThat(money.toDouble(), is(23.0));
    }
}

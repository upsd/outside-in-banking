import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClockShould {

    @Test
    public void return_date_as_dd_slash_mm_slash_yyyy() {
        LocalDate localDate = LocalDate.of(2018, 05, 8);

        Clock clock = new Clock();
        String dateAsString = clock.getDateAsString(localDate);

        assertThat(dateAsString, is("08/05/2018"));
    }
}

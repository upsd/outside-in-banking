import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public String getDateAsString(LocalDate date) {
        DateTimeFormatter ddmmyyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(ddmmyyyy);
    }
}

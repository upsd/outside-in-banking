import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

    private Money money;
    private TransactionType type;
    private LocalDate date;

    public Transaction(Money money, TransactionType type, LocalDate currentDateAsString) {
        this.money = money;
        this.type = type;
        this.date = currentDateAsString;
    }

    public double amount() {
        return this.money.toDouble();
    }

    public TransactionType type() {
        return this.type;
    }

    public LocalDate date() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(money, that.money) &&
                type == that.type &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(money, type, date);
    }
}

import java.time.LocalDate;

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
}

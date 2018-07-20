import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void print(Console printer, StatementFormatter statementFormatter, ClockFormatter clockFormatter) {
        String statement = statementFormatter.formatUsing(this.transactions, clockFormatter);
        printer.print(statement);
    }
}

public class TransactionController {

    private final Transactions transactions;

    public TransactionController(Transactions transactions) {
        this.transactions = transactions;
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void print(Console printer, ClockFormatter clockFormatter) {
        this.transactions.print(printer, new StatementFormatter(), clockFormatter);
    }
}

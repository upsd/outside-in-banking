import java.time.LocalDate;

public class ATM {

    private Console printer;
    private TransactionController transactionController;
    private Clock clock;

    public ATM(Console printer, TransactionController transactionController, Clock clock) {
        this.printer = printer;
        this.transactionController = transactionController;
        this.clock = clock;
    }

    public void deposit(Money money) {
        this.transactionController.add(new Transaction(money, TransactionType.DEPOSIT, LocalDate.now()));
    }

    public void withdraw(Money money) {
        this.transactionController.add(new Transaction(money, TransactionType.WITHDRAW, LocalDate.now()));
    }

    public void print() {
        String statement = StatementFormatter.formatUsing(this.transactionController.getTransactions(), this.clock);
        this.printer.print(statement);
    }
}

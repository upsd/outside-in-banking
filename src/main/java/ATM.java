import java.time.LocalDate;

public class ATM {

    private Console printer;
    private TransactionController transactionController;
    private ClockFormatter clockFormatter;

    public ATM(Console printer, TransactionController transactionController, ClockFormatter clockFormatter) {
        this.printer = printer;
        this.transactionController = transactionController;
        this.clockFormatter = clockFormatter;
    }

    public void deposit(Money money) {
        this.transactionController.add(new Transaction(money, TransactionType.DEPOSIT, LocalDate.now()));
    }

    public void withdraw(Money money) {
        this.transactionController.add(new Transaction(money, TransactionType.WITHDRAW, LocalDate.now()));
    }

    public void print() {
        String statement = StatementFormatter.formatUsing(this.transactionController.getTransactions(), this.clockFormatter);
        this.printer.print(statement);
    }
}

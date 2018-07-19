public class TransactionController {

    private Transactions transactions = new Transactions();

    public Transactions getTransactions() {
        return this.transactions;
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }
}

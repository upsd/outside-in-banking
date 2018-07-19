import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Transactions {

    private List<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> toList() {
        return unmodifiableList(this.transactions);
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }
}

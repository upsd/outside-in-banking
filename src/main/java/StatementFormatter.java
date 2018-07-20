import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StatementFormatter {

    private static final String HEADER = "date || credit || debit || balance";

    public String formatUsing(List<Transaction> transactions, ClockFormatter clockFormatter) {
        final double[] balance = {0};

        List<String> formattedTransactions = transactions
                .stream()
                .map(t -> {
                    double amountRounded = t.amount();
                    String date = clockFormatter.getDateAsString(t.date());

                    if (t.type() == TransactionType.DEPOSIT) {
                        return String.format("%s || %.2f || || %.2f", date, amountRounded, (balance[0] += amountRounded));
                    }
                    return String.format("%s || || %.2f || %.2f", date, amountRounded, (balance[0] -= amountRounded));
                })
                .collect(Collectors.toList());

        Collections.reverse(formattedTransactions);
        String statementWithoutHeader = formattedTransactions.stream().collect(Collectors.joining("\n"));

        return HEADER + "\n" + statementWithoutHeader;
    }
}

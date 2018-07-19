import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StatementFormatter {

    private static final String HEADER = "date || credit || debit || balance";

    public static String formatUsing(Transactions transactions, Clock clock) {
        final double[] balance = {0};

        List<String> formattedTransactions = transactions
                .toList()
                .stream()
                .map(t -> {
                    double amountRounded = t.amount();
                    String date = clock.getDateAsString(t.date());

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

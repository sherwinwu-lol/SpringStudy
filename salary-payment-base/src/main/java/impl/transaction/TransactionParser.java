package impl.transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionParser {
    List<Transaction> itsTransactions = new LinkedList<>();

    public void addTransaction(Transaction t) {
        itsTransactions.add(t);
    }

    public void run() {
        while (!itsTransactions.isEmpty()) {
            Transaction t = itsTransactions.get(0);
            itsTransactions.remove(0);
            try {
                t.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

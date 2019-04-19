package impl.source;

import impl.transaction.Transaction;

import java.util.LinkedList;

public class TextParserTransactionSource implements TransactionSource {
    LinkedList<Transaction> transactionList = new LinkedList<>();

    public void addTransaction(Transaction t) {
        transactionList.add(t);
    }

    public void run() {
        while (!transactionList.isEmpty()) {
            Transaction t = transactionList.getFirst();
            transactionList.removeFirst();
            try {
                t.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Transaction getTransaction() {
        Transaction t = transactionList.getFirst();
        transactionList.removeFirst();
        return t;
    }
}

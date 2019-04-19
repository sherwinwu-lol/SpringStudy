package impl.source;

import impl.transaction.Transaction;

public interface TransactionSource {
    Transaction getTransaction();
}

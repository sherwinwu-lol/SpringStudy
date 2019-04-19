package impl;

import impl.transaction.ServiceChargeTransaction;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        ServiceChargeTransaction sct = new ServiceChargeTransaction(DateTime.now(), 1.0, 11);
        sct.execute();
    }
}

package impl;

import impl.transaction.Transaction;
import impl.util.FileUtil;

import java.util.Scanner;

public class PayrollApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入文件名");
        Scanner scan = new Scanner(System.in);
        String transactionStr = scan.next();
        while (true) {
            try {
                Transaction t = (Transaction) FileUtil.parseJSONToObject(transactionStr);
                t.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("请输入文件名");
            transactionStr = scan.next();
        }
    }
}
//banking.reports.CustomerReport.java

package banking.reports;

import banking.domain.Bank;

public class CustomerReport {
    public CustomerReport() {
    }

    public void generateReport(Bank bank) {
        System.out.println("CUSTOMERS REPORT");
        System.out.println("================");
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            if (i == 1) {
                System.out.println("储户姓名：" + bank.getCustomer(1).getName());
                System.out.println("Checking Account: 当前余额是￥"
                        + bank.getCustomer(1).getAccount(0).getBalance());
                System.out.println();
            } else {
                System.out.println("储户姓名：" + bank.getCustomer(i).getName());
                System.out.println("Savings Account: 当前余额是￥"
                        + bank.getCustomer(i).getAccount(0).getBalance());
                System.out.println("Checking Account: 当前余额是￥"
                        + bank.getCustomer(i).getAccount(1).getBalance());
                System.out.println();
            }
        }
    }
}

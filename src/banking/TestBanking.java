//banking.TestBanking.java

package banking;

import banking.domain.Bank;
import banking.domain.CheckingAccount;
import banking.domain.OverdraftException;
import banking.domain.SavingsAccount;
import banking.reports.CustomerReport;

public class TestBanking {
    public static void main(String[] args) throws OverdraftException {
        Bank B = new Bank();
        B.addCustomer("Jane", "Simms");
        B.addCustomer("Owen", "Bryant");
        B.addCustomer("Tim", "Soley");
        B.addCustomer("Maria", "Soley");
        B.getCustomer(0).addAccount(
                new SavingsAccount(500.00, 0.05));
        B.getCustomer(0).addAccount(
                new CheckingAccount(200.00, true, 400.00));
        B.getCustomer(1).addAccount(
                new CheckingAccount(200.00));
        B.getCustomer(2).addAccount(
                new SavingsAccount(1500.00, 0.05));
        B.getCustomer(2).addAccount(
                new CheckingAccount(300.00));
        B.getCustomer(3).addAccount(
                new SavingsAccount(150.00, 0.05));
        B.getCustomer(3).addAccount(
                B.getCustomer(2).getAccount(1));
        try {
            B.getCustomer(0).getAccount(0).deposit(100);
            B.getCustomer(1).getAccount(0).deposit(200);
            B.getCustomer(2).getAccount(0).withdraw(100);
            B.getCustomer(0).getAccount(1).withdraw(500);
            B.getCustomer(2).getAccount(1).withdraw(600);
        } catch (OverdraftException e) {
            e.printStackTrace();
        }

        CustomerReport t = new CustomerReport();
        t.generateReport(B);

    }
}

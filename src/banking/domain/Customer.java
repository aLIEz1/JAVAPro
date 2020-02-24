//banking.domain.Customer.java

package banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private List<Account> accounts = new ArrayList<Account>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + "·" + this.lastName;
    }

    public void addAccount(Account acc) {
        this.accounts.add(acc);

    }

    public Account getAccount(int account_index) {
        return accounts.get(account_index);
    }

    public int getNumOfAccounts() {
        return this.accounts.size();
    }

    public Iterator<Account> getAccounts() {
        return accounts.iterator();
    }

}

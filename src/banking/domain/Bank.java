//banking.domain.Bank.java

package banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private List<Customer> customers = new ArrayList<Customer>();

    public Bank() {
    }

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
    }

    public Customer getCustomer(int customer_index) {
        return customers.get(customer_index);
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Iterator<Customer> getCustomers() {
        return customers.iterator();
    }
}

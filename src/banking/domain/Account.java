//banking.domain.Account.java

package banking.domain;

public abstract class Account {
    private double balance;

    public Account(double iniBalance) {
        balance = iniBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws OverdraftException {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
        } else {
            throw new OverdraftException("取款超过余额");
        }

    }
}

//banking.domain.SavingsAccount.java

package banking.domain;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double iniBalance, double interestRate) {
        super(iniBalance);
        this.interestRate = interestRate;
    }
}

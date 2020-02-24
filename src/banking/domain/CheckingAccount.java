//banking.domain.CheckingAccount.java

package banking.domain;

public class CheckingAccount extends Account {
    private boolean canOverdraft;
    private double maxOverdraft;

    public CheckingAccount(double iniBalance) {
        super(iniBalance);
        this.canOverdraft = false;
        this.maxOverdraft = 0.00;
    }

    public CheckingAccount(double iniBalance, boolean canOverdraft, double maxOverdraft) {
        super(iniBalance);
        this.canOverdraft = canOverdraft;
        this.maxOverdraft = maxOverdraft;
    }

    public void withdraw(double amount) throws OverdraftException {
        if (this.canOverdraft && this.maxOverdraft >= 0) {
            if (getBalance() - amount <= this.maxOverdraft) {
                setBalance(getBalance() - amount);
                this.maxOverdraft -= 100;
            } else {
                throw new OverdraftException("超过最大透支额度");
            }
        } else {
            throw new OverdraftException("账户不允许透支");
        }
    }
}

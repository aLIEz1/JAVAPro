//banking.domain.OverdraftException.java

package banking.domain;

public class OverdraftException extends Exception {
    private static final long serialVersionUID = 1L;

    public OverdraftException() {
        super();
    }

    public OverdraftException(String msg) {
        super(msg);
    }

}

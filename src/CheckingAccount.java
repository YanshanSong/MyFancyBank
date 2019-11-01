import java.util.Map;

/**
 * The class extends the Account class and represents a checking account of a customer
 */
public class CheckingAccount extends Account {
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(Map<String, String> account) {
        super(account);
    }
}

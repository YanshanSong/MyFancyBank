import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * The class represents a generic class for a checking account and a saving account
 */
public class Account {
    protected Map<String, String> account;

    public Account() {
        account = new HashMap<>();
        account.put("USD", "0.00");
        account.put("GBP", "0.00");
        account.put("EUR", "0.00");
        account.put("CNY", "0.00");
    }

    public Account(Map<String, String> account) {
        this.account = account;
    }

    public Map getAccount() {
        return account;
    }

    public void setBalanceByKey(String key, String value) {
        account.put(key, value);
    }

    public String getBalanceByKey(String key) {
        return account.get(key);
    }

    public void addBalanceByKey(String key, String increment) {
        String originalBalance = account.get(key);
        Double newBalanceDouble = Double.valueOf(originalBalance) + Double.valueOf(increment);
        String newBalance = String.format("%.2f", newBalanceDouble);
        account.put(key, newBalance);
    }

    public void deductBalanceByKey(String key, String decrement) {
        String originalBalance = account.get(key);
        Double newBalanceDouble = Double.valueOf(originalBalance) - Double.valueOf(decrement);
        String newBalance = String.format("%.2f", newBalanceDouble);
        account.put(key, newBalance);
    }
}
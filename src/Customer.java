import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * The class represents a customer.
 */
public class Customer {

    private String name;
    private String password;
    private String email;
    private String address;

    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    private boolean accountOpenFee;
    private int currentMonth;
    private int freeTransferChance;

    private String operatingDate;

    private ArrayList<Loan> loans;

    public Customer(String name, String password, String address, String email) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;

        checkingAccount = new CheckingAccount();
        savingAccount = new SavingAccount();
        accountOpenFee = false;

        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(calendar.MONTH) + 1;
        freeTransferChance = 3;

        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
        operatingDate = ft.format(date);

        loans = new ArrayList<>();
    }

    public Customer(String name,
                    String password,
                    String email,
                    String address,
                    CheckingAccount checkingAccount,
                    SavingAccount savingAccount,
                    boolean accountOpenFee,
                    int currentMonth,
                    int freeTransferChance,
                    String operatingDate,
                    ArrayList<Loan> loans) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;

        this.savingAccount = savingAccount;
        this.checkingAccount = checkingAccount;

        this.accountOpenFee = accountOpenFee;
        this.currentMonth = currentMonth;
        this.freeTransferChance = freeTransferChance;

        this.operatingDate = operatingDate;

        this.loans = loans;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public void setAccountOpenFee(boolean flag) {
        accountOpenFee = flag;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setFreeTransferChance(int freeTransferChance) {
        this.freeTransferChance = freeTransferChance;
    }

    public void setOperatingDate(String operatingDate) {
        this.operatingDate = operatingDate;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public boolean getAccountOpenFee() {
        return accountOpenFee;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getFreeTransferChance() {
        return freeTransferChance;
    }

    public String getOperatingDate() {
        return operatingDate;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}

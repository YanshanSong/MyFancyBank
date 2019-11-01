/**
 * The class represents a loan.
 */
public class Loan {
    private int index;
    private String applicationTime;
    private String collateral;
    private String loanAmount;
    private String debt;

    public Loan(int index, String applicationTime, String collateral, String loanAmount) {
        this.index = index;
        this.applicationTime = applicationTime;
        this.collateral = collateral;
        this.loanAmount = String.format("%.2f", Double.valueOf(loanAmount));
        this.debt = this.loanAmount;
    }

    public Loan(int index, String applicationTime, String collateral, String loanAmount, String debt) {
        this.index = index;
        this.applicationTime = applicationTime;
        this.collateral = collateral;
        this.loanAmount = loanAmount;
        this.debt = debt;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }


    public void setDebt(String debt) {
        this.debt = debt;
    }

    public int getIndex() {
        return index;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public String getCollateral() {
        return collateral;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getDebt() {
        return debt;
    }

    public void repay(String decrement) {
        debt = String.format("%.2f", Double.valueOf(debt) - Double.valueOf(decrement));
    }

    public void addInterest(String increment) {
        debt = String.format("%.2f", Double.valueOf(debt) + Double.valueOf(increment));
    }
}

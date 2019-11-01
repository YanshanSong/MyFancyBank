import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Interest {
    private Customer customer;
    private double savingInterestRate = 0.00005;
    private double loanInterestRate = 0.0001;

    public Interest(Customer customer) {
        this.customer = customer;
    }

    public void calculateInterest() throws ParseException {
        // calculate the day span
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
        String lastOperatingDate = customer.getOperatingDate();
        Date date1 = ft.parse(lastOperatingDate);

        Date date = new Date();
        String currentOperatingDate = ft.format(date);
        Date date2 = ft.parse(currentOperatingDate);

        int daySpan = 0;
        if(lastOperatingDate.equals(currentOperatingDate)) {
            daySpan = 0;
        }else{
            daySpan = (int) (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1;
        }
        // update the customer's operatingDate
        customer.setOperatingDate(currentOperatingDate);

        calculateInterestByDaySpan(daySpan);
    }

    public void calculateInterestByDaySpan(int daySpan) {
        // calculate the interest of balance in the saving account and update the saving account
        Map<String, String> account = customer.getSavingAccount().getAccount();
        for(String key: account.keySet()) {
            double saving = Double.valueOf(account.get(key));
            if(saving >= 10000) {
                double savingInterest = saving * savingInterestRate * daySpan;
                customer.getSavingAccount().addBalanceByKey(key, String.valueOf(savingInterest));
            }
        }

        // calculate the interest of the loan and update the loan information
        int loanSize = customer.getLoans().size();
        if(loanSize > 1) {
            Loan loan = customer.getLoans().get(loanSize - 1);
            double debt = Double.valueOf(loan.getDebt());
            if (!loan.getDebt().equals("0.00")) {
                double loanInterest = debt * loanInterestRate * daySpan;
                loan.addInterest(String.valueOf(loanInterest));
            }
        }
    }

}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class is designed to check the validity of the input number.
 */

public class NumberValidation {

    public boolean isDepositNumberValid(String number){
        String pattern = "^[1-9]\\d*00$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(number);
        if(m.find()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isWithdrawalNumberValid(String number) {
        return isDepositNumberValid(number);
    }

    public boolean isTransferNumberValid(String number) {
        String pattern = "^(?:[1-9]\\d*|0)(?:|\\.\\d{1,2})$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(number);
        if(m.find()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isLoanNumberValid(String number) {
        return isDepositNumberValid(number);
    }

//    public static void main(String[] args) {
//        NumberValidation nv = new NumberValidation();
//        boolean rs = nv.isLoanNumberValid("300");
//        System.out.println(rs);
//    }

}

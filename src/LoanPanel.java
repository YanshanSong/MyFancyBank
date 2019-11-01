import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * The class is use to control the panel of applying and repaying a loan.
 */

public class LoanPanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;

    private NumberValidation nv;
    private JsonRW jsonRW;

    /**
     * Create the panel.
     */
    public LoanPanel(Customer customer) throws IOException {
        nv = new NumberValidation();
        jsonRW = new JsonRW();

        setBounds(0, 0, 500, 500);
        setLayout(null);
        JLabel lblNewLabel = new JLabel("Loan");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(10, 10, 39, 16);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Loan Information");
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(196, 40, 108, 16);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Checking Account");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(193, 160, 115, 16);
        add(lblNewLabel_2);

        // set a table to show the information of loans
        String[] titleL = {"Index", "Application Time", "Collateral", "Loan Amount", "Debt"};
        String[][] dataL = new String[customer.getLoans().size()][titleL.length];
        for (int i = 0; i < customer.getLoans().size(); i++) {
            Loan loan = customer.getLoans().get(i);
            dataL[i][0] = String.valueOf(loan.getIndex());
            dataL[i][1] = loan.getApplicationTime();
            dataL[i][2] = loan.getCollateral();
            dataL[i][3] = loan.getLoanAmount();
            dataL[i][4] = loan.getDebt();
        }

        Table tableL = new Table(titleL, dataL);
        JScrollPane jScrollPaneL = tableL.generateTable();
        jScrollPaneL.setBounds(20, 60, 460, 90);
        tableL.setColumnWidth(0, 50);
        add(jScrollPaneL);

        // set a table to show the checking account
        String[] titleC = {"CurrencyName", "CuccenyNumber"};
        String[][] dataC = {{"USD", customer.getCheckingAccount().getBalanceByKey("USD")}};
        Table tableC = new Table(titleC, dataC);
        JScrollPane jScrollPaneC = tableC.generateTable();
        jScrollPaneC.setBounds(150, 180, 200, 40);
        add(jScrollPaneC);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.GRAY));
        panel.setForeground(Color.BLACK);
        panel.setBounds(20, 240, 300, 240);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Loan Application");
        lblNewLabel_3.setForeground(Color.BLUE);
        lblNewLabel_3.setBounds(97, 5, 106, 16);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Collateral:");
        lblNewLabel_4.setBounds(6, 89, 69, 16);
        panel.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setBounds(90, 84, 200, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Amount:");
        lblNewLabel_5.setBounds(14, 135, 61, 16);
        panel.add(lblNewLabel_5);

        textField_1 = new JTextField();
        textField_1.setBounds(90, 130, 200, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("apply");
        btnNewButton.setBounds(91, 170, 117, 29);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.setBounds(90, 205, 117, 29);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("daily interest rate: 0.01%");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblNewLabel_6.setForeground(Color.RED);
        lblNewLabel_6.setBounds(89, 25, 122, 16);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("The max amount of loan you can apply is 1,000,000");
        lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblNewLabel_7.setForeground(Color.RED);
        lblNewLabel_7.setBounds(25, 40, 250, 16);
        panel.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Please input the multiple of 100 !");
        lblNewLabel_8.setForeground(Color.RED);
        lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblNewLabel_8.setBounds(67, 55, 165, 16);
        panel.add(lblNewLabel_8);

        label = new JLabel("");
        label.setForeground(Color.RED);
        label.setBounds(90, 69, 197, 16);
        panel.add(label);

        label_1 = new JLabel("");
        label_1.setForeground(Color.RED);
        label_1.setBounds(93, 115, 197, 16);
        panel.add(label_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.GRAY));
        panel_1.setBounds(346, 240, 140, 240);
        add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_9 = new JLabel("Repayment");
        lblNewLabel_9.setForeground(Color.BLUE);
        lblNewLabel_9.setBounds(35, 6, 70, 16);
        panel_1.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Amount:");
        lblNewLabel_10.setBounds(40, 84, 60, 16);
        panel_1.add(lblNewLabel_10);

        textField_2 = new JTextField();
        textField_2.setBounds(6, 130, 130, 26);
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        label_2 = new JLabel("");
        label_2.setForeground(Color.RED);
        label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        label_2.setBounds(9, 112, 125, 16);
        panel_1.add(label_2);

        JButton btnNewButton_2 = new JButton("Repay");
        btnNewButton_2.setBounds(11, 170, 117, 29);
        panel_1.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Reset");
        btnNewButton_3.setBounds(11, 205, 117, 29);
        panel_1.add(btnNewButton_3);

        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearLoanLabel();
                // check whether the last loan has been fully repaid
                int loanSize = customer.getLoans().size();
                if (loanSize != 0) {
                    Loan loan = customer.getLoans().get(loanSize - 1);
                    if (!loan.getDebt().equals("0.00")) {
                        String reminder = "Before you fully repay you last loan, you cannot apply a new loan!";
                        JOptionPane.showInternalMessageDialog(null, reminder, "Info", JOptionPane.INFORMATION_MESSAGE);
                        clearLoanField();
                        return;
                    }
                }

                String collateral = textField.getText();
                String amount = textField_1.getText();

                // do validation
                boolean valid = true;
                if (collateral.equals("")) {
                    label.setText("Please enter the collateral!");
                    valid = false;
                }

                if (!amount.equals("")) {
                    if (nv.isLoanNumberValid(amount)) {
                        if (Double.valueOf(amount) > 1000000) {
                            label_1.setText("Exceed the max amount!");
                            valid = false;
                        }
                    } else {
                        label_1.setText("Invalid input!");
                        valid = false;
                    }
                } else {
                    valid = false;
                    label_1.setText("Please enter the amount of loan!");
                }

                if (valid) { // the amount of loan is valid
                    int index = loanSize + 1;
                    String date = customer.getOperatingDate();
                    Loan loan = new Loan(index, date, collateral, amount);
                    customer.getLoans().add(loan);

                    // add the amount of loan to the checking account
                    customer.getCheckingAccount().addBalanceByKey("USD", loan.getLoanAmount());

                    // update the table showing the information of loans
                    String[] rowDate = {String.valueOf(index), date, collateral, loan.getLoanAmount(), loan.getDebt()};
                    tableL.addRowData(rowDate);

                    // update the table showing the checking account
                    tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey("USD"), 0, 1);

                    // use a popup window to give a reminder
                    String info = "Congratulations! You have successfully got a loan of " + amount + "!";
                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                    clearLoanField();

                    // update the transactions json file
                    String detailedContent = "Get a loan of " + amount + " USD.";
                    Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Loan", detailedContent, "/");
                    try {
                        jsonRW.updateTransactions(transaction);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearLoanLabel();
                clearLoanField();
            }
        });

        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_2.setText("");

                String amount = textField_2.getText();
                int loanSize = customer.getLoans().size();
                Loan loan = customer.getLoans().get(loanSize - 1);

                boolean valid = true;

                if (!amount.equals("")) {
                    if (nv.isTransferNumberValid(amount)) {
                        if (Double.valueOf(amount) > Double.valueOf(customer.getCheckingAccount().getBalanceByKey("USD"))) {
                            valid = false;
                            label_2.setText("Exceed balance!");
                        } else if (Double.valueOf(amount) > Double.valueOf(loan.getDebt())) {
                            valid = false;
                            label_2.setText("Exceed debt!");
                        }
                    } else {
                        valid = false;
                        label_2.setText("Invalid input!");
                    }
                } else {
                    valid = false;
                    label_2.setText("Please input the amount of repayment!");
                }

                if (valid) {
                    // get the money from checking account;
                    customer.getCheckingAccount().deductBalanceByKey("USD", amount);

                    // repay the debt
                    loan.repay(amount);

                    // update the table showing the information of loans
                    tableL.setTableValue(loan.getDebt(), loan.getIndex() - 1, 4);

                    // update the table showing the checking account
                    tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey("USD"), 0, 1);

                    textField_2.setText("");

                    // use a popup window to give a reminder
                    String info = "You have successfully repaid " + amount + " USD!";
                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);

                    if (loan.getDebt().equals("0.00")) {
                        info = "You have fully repaid the loan, now you can apply a new loan!";
                        JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    clearLoanField();

                     // update the transactions json file
                    String detailedContent = "Repay " + amount + " USD.";
                    Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Repayment", detailedContent, "/");
                    try {
                        jsonRW.updateTransactions(transaction);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    public void clearLoanLabel() {
        label.setText("");
        label_1.setText("");
    }

    public void clearLoanField() {
        textField.setText("");
        textField_1.setText("");
    }
}

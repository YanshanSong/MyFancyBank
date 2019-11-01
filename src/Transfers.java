import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The class is used to control the panel of transfers.
 */

public class Transfers extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;

    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel label_10;
    private JLabel label_11;

    private NumberValidation nv;
    private JsonRW jsonRW;

    /**
     * Create the panel.
     */
    public Transfers(Customer customer) throws IOException {
        nv = new NumberValidation();
        jsonRW = new JsonRW();

        setBounds(0, 0, 500, 500);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Transfers");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(10, 10, 79, 16);
        add(lblNewLabel);

        // use two tables to show the balance in the checking account and the saving account respectively
        ArrayList<String> tableCurrencyName = new ArrayList<>();
        tableCurrencyName.add("USD");
        tableCurrencyName.add("GBP");
        tableCurrencyName.add("EUR");
        tableCurrencyName.add("CNY");

        String[] title = {"Currency", "Balance"};
        int dataSize = customer.getCheckingAccount().getAccount().size();
        String[][] data = new String[dataSize][2];
        for (int i = 0; i < dataSize; i++) {
            data[i][0] = tableCurrencyName.get(i);
            data[i][1] = customer.getCheckingAccount().getBalanceByKey(data[i][0]);
        }

        Table tableC = new Table(title, data);
        JScrollPane jScrollPaneC = tableC.generateTable();
        jScrollPaneC.setBounds(20, 60, 200, 90);
        add(jScrollPaneC);

        dataSize = customer.getSavingAccount().getAccount().size();
        for (int i = 0; i < dataSize; i++) {
            data[i][0] = tableCurrencyName.get(i);
            data[i][1] = customer.getSavingAccount().getBalanceByKey(data[i][0]);
        }

        Table tableS = new Table(title, data);
        JScrollPane jScrollPaneS = tableS.generateTable();
        jScrollPaneS.setBounds(280, 60, 200, 90);
        add(jScrollPaneS);

        JLabel lblNewLabel_1 = new JLabel("Checking Account");
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.setBounds(62, 40, 115, 16);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Saving Account");
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(331, 40, 97, 16);
        add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.GRAY));
        panel.setBounds(20, 200, 130, 280);
        add(panel);

        JLabel lblNewLabelUSD = new JLabel("USD:");
        lblNewLabelUSD.setBounds(15, 30, 36, 16);
        panel.add(lblNewLabelUSD);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(53, 25, 65, 26);
        panel.add(textField);

        JLabel lblNewLabelGBP = new JLabel("GBP:");
        lblNewLabelGBP.setBounds(15, 70, 36, 16);
        panel.add(lblNewLabelGBP);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(53, 65, 65, 26);
        panel.add(textField_1);

        JLabel lblNewLabelEUR = new JLabel("EUR:");
        lblNewLabelEUR.setBounds(15, 110, 36, 16);
        panel.add(lblNewLabelEUR);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(53, 105, 65, 26);
        panel.add(textField_2);

        JLabel lblNewLabelCNY = new JLabel("CNY:");
        lblNewLabelCNY.setBounds(15, 150, 36, 16);
        panel.add(lblNewLabelCNY);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(53, 145, 65, 26);
        panel.add(textField_3);

        JButton btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(15, 190, 100, 29);
        panel.add(btnTransfer);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(15, 230, 100, 29);
        panel.add(btnReset);

        label = new JLabel("");
        label.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label.setForeground(Color.RED);
        label.setBounds(50, 10, 75, 16);
        panel.add(label);

        label_1 = new JLabel("");
        label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_1.setForeground(Color.RED);
        label_1.setBounds(50, 50, 75, 16);
        panel.add(label_1);

        label_2 = new JLabel("");
        label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_2.setForeground(Color.RED);
        label_2.setBounds(50, 90, 75, 16);
        panel.add(label_2);

        label_3 = new JLabel("");
        label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_3.setForeground(Color.RED);
        label_3.setBounds(50, 130, 75, 16);
        panel.add(label_3);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(Color.GRAY));
        panel_1.setBounds(185, 200, 130, 280);
        add(panel_1);

        JLabel lblNewLabelUSD_1 = new JLabel("USD:");
        lblNewLabelUSD_1.setBounds(15, 30, 36, 16);
        panel_1.add(lblNewLabelUSD_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(53, 25, 65, 26);
        panel_1.add(textField_4);

        JLabel lblNewLabelGBP_1 = new JLabel("GBP:");
        lblNewLabelGBP_1.setBounds(15, 70, 36, 16);
        panel_1.add(lblNewLabelGBP_1);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(53, 65, 65, 26);
        panel_1.add(textField_5);

        JLabel lblNewLabelEUR_1 = new JLabel("EUR:");
        lblNewLabelEUR_1.setBounds(15, 110, 36, 16);
        panel_1.add(lblNewLabelEUR_1);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(53, 105, 65, 26);
        panel_1.add(textField_6);

        JLabel lblNewLabelCNY_1 = new JLabel("CNY:");
        lblNewLabelCNY_1.setBounds(15, 150, 36, 16);
        panel_1.add(lblNewLabelCNY_1);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(53, 145, 65, 26);
        panel_1.add(textField_7);

        JButton btnTransfer_1 = new JButton("Transfer");
        btnTransfer_1.setBounds(15, 190, 100, 29);
        panel_1.add(btnTransfer_1);

        JButton btnReset_1 = new JButton("Reset");
        btnReset_1.setBounds(15, 230, 100, 29);
        panel_1.add(btnReset_1);

        label_4 = new JLabel("");
        label_4.setForeground(Color.RED);
        label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_4.setBounds(50, 10, 75, 16);
        panel_1.add(label_4);

        label_5 = new JLabel("");
        label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_5.setForeground(Color.RED);
        label_5.setBounds(50, 50, 75, 16);
        panel_1.add(label_5);

        label_6 = new JLabel("");
        label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_6.setForeground(Color.RED);
        label_6.setBounds(50, 90, 75, 16);
        panel_1.add(label_6);

        label_7 = new JLabel("");
        label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_7.setForeground(Color.RED);
        label_7.setBounds(50, 130, 75, 16);
        panel_1.add(label_7);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBorder(new LineBorder(Color.GRAY));
        panel_2.setBounds(350, 180, 130, 300);
        add(panel_2);

        JLabel lblNewLabelUSD_2 = new JLabel("USD:");
        lblNewLabelUSD_2.setBounds(15, 50, 36, 16);
        panel_2.add(lblNewLabelUSD_2);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(53, 45, 65, 26);
        panel_2.add(textField_9);

        JLabel lblNewLabelGBP_2 = new JLabel("GBP:");
        lblNewLabelGBP_2.setBounds(15, 90, 36, 16);
        panel_2.add(lblNewLabelGBP_2);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(53, 85, 65, 26);
        panel_2.add(textField_10);

        JLabel lblNewLabelERU_2 = new JLabel("EUR:");
        lblNewLabelERU_2.setBounds(15, 130, 36, 16);
        panel_2.add(lblNewLabelERU_2);

        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(53, 125, 65, 26);
        panel_2.add(textField_11);

        JLabel lblNewLabelCNY_2 = new JLabel("CNY:");
        lblNewLabelCNY_2.setBounds(15, 170, 36, 16);
        panel_2.add(lblNewLabelCNY_2);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(53, 165, 65, 26);
        panel_2.add(textField_12);

        JButton btnTransfer_2 = new JButton("Transfer");
        btnTransfer_2.setBounds(15, 210, 100, 29);
        panel_2.add(btnTransfer_2);

        JButton btnReset_2 = new JButton("Reset");
        btnReset_2.setBounds(15, 250, 100, 29);
        panel_2.add(btnReset_2);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(53, 10, 65, 26);
        panel_2.add(textField_8);

        label_8 = new JLabel("");
        label_8.setForeground(Color.RED);
        label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_8.setBounds(50, 30, 75, 16);
        panel_2.add(label_8);

        label_9 = new JLabel("");
        label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_9.setForeground(Color.RED);
        label_9.setBounds(50, 70, 75, 16);
        panel_2.add(label_9);

        label_10 = new JLabel("");
        label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_10.setForeground(Color.RED);
        label_10.setBounds(50, 110, 75, 16);
        panel_2.add(label_10);

        label_11 = new JLabel("");
        label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        label_11.setForeground(Color.RED);
        label_11.setBounds(50, 150, 75, 16);
        panel_2.add(label_11);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(6, 15, 45, 16);
        panel_2.add(lblName);

        JLabel lblNewLabel_3 = new JLabel("from Checking to Saving");
        lblNewLabel_3.setForeground(Color.BLUE);
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblNewLabel_3.setBounds(27, 150, 115, 10);
        add(lblNewLabel_3);

        JLabel lblFromSavingTo = new JLabel("from Saving to Checking");
        lblFromSavingTo.setForeground(Color.BLUE);
        lblFromSavingTo.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblFromSavingTo.setBounds(192, 150, 115, 10);
        add(lblFromSavingTo);

        JLabel lblFromPersonTo = new JLabel("from Person to Person");
        lblFromPersonTo.setForeground(Color.BLUE);
        lblFromPersonTo.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblFromPersonTo.setBounds(363, 150, 103, 10);
        add(lblFromPersonTo);

        JLabel lblNewLabel_4 = new JLabel("free");
        lblNewLabel_4.setForeground(Color.RED);
        lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblNewLabel_4.setBounds(78, 160, 17, 10);
        add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Each month 3 free chances.");
        lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblNewLabel_5.setForeground(Color.RED);
        lblNewLabel_5.setBounds(185, 160, 130, 10);
        add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("After free chances, you will ");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblNewLabel_6.setForeground(Color.RED);
        lblNewLabel_6.setBounds(185, 170, 130, 10);
        add(lblNewLabel_6);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(306, 79, 1, 16);
        add(textPane);

        JLabel lblBeCharged = new JLabel("be charged a fee of 10 USD");
        lblBeCharged.setForeground(Color.RED);
        lblBeCharged.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblBeCharged.setBounds(185, 180, 130, 10);
        add(lblBeCharged);

        String content = String.format("each transfer.  Remaining(%d)", customer.getFreeTransferChance());
        JLabel lblTransfer = new JLabel(content);
        lblTransfer.setForeground(Color.RED);
        lblTransfer.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblTransfer.setBounds(185, 190, 130, 10);
        add(lblTransfer);

        JLabel lblEach = new JLabel("Each transfer will be charged");
        lblEach.setForeground(Color.RED);
        lblEach.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblEach.setBounds(350, 160, 135, 10);
        add(lblEach);

        JLabel lblAFeeOf = new JLabel("a fee of 10 USD.");
        lblAFeeOf.setForeground(Color.RED);
        lblAFeeOf.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblAFeeOf.setBounds(350, 170, 130, 10);
        add(lblAFeeOf);

        btnTransfer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String USD = textField.getText();
                String GBP = textField_1.getText();
                String EUR = textField_2.getText();
                String CNY = textField_3.getText();

                clearCTSLabel();

                ArrayList<String> currencyNameList = new ArrayList<>();
                ArrayList<String> currencyNumberList = new ArrayList<>();

                if (!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
                    // do validation
                    boolean validUSD = true;
                    boolean validGBP = true;
                    boolean validEUR = true;
                    boolean validCNY = true;

                    if (!USD.equals("")) {
                        validUSD = validation("USD", USD, customer.getCheckingAccount(), label, currencyNameList, currencyNumberList);
                    }

                    if (!GBP.equals("")) {
                        validGBP = validation("GBP", GBP, customer.getCheckingAccount(), label_1, currencyNameList, currencyNumberList);
                    }

                    if (!EUR.equals("")) {
                        validEUR = validation("EUR", EUR, customer.getCheckingAccount(), label_2, currencyNameList, currencyNumberList);
                    }
                    if (!CNY.equals("")) {
                        validCNY = validation("CNY", CNY, customer.getCheckingAccount(), label_3, currencyNameList, currencyNumberList);
                    }

                    if (validUSD && validGBP && validEUR && validCNY) { // the transfer numbers are valid
                        String transferInfo = "";
                        for (int i = 0; i < currencyNameList.size(); i++) {
                            // get the money from the checking account
                            String key = currencyNameList.get(i);
                            String decrement = currencyNumberList.get(i);
                            customer.getCheckingAccount().deductBalanceByKey(key, decrement);

                            transferInfo += decrement + " " + key + ",";

                            // transfer the money to the saving account
                            String increment = decrement;
                            customer.getSavingAccount().addBalanceByKey(key, increment);

                            // update two tables
                            int tableRowIndex = tableCurrencyName.indexOf(key);
                            tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey(key), tableRowIndex, 1);
                            tableS.setTableValue(customer.getSavingAccount().getBalanceByKey(key), tableRowIndex, 1);
                        }

                        transferInfo = transferInfo.substring(0, transferInfo.length() - 1);
                        String info = "You have successfully transferred " + transferInfo + " from your checking account to your saving account!";
                        JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                        clearCTSField();

                        // update the transactions json file
                        String detailedContent = "Transfer " + transferInfo + " from the checking account to the saving account.";
                        Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Transfer", detailedContent, "/");
                        try {
                            jsonRW.updateTransactions(transaction);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    String info = "Please enter you transfer number!";
                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearCTSLabel();
                clearCTSField();
            }
        });

        // transfer from the saving account to the checking account
        btnTransfer_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String USD = textField_4.getText();
                String GBP = textField_5.getText();
                String EUR = textField_6.getText();
                String CNY = textField_7.getText();

                clearSTCLabel();

                ArrayList<String> currencyNameList = new ArrayList<>();
                ArrayList<String> currencyNumberList = new ArrayList<>();

                if (!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
                    // do validation
                    boolean validUSD = true;
                    boolean validGBP = true;
                    boolean validEUR = true;
                    boolean validCNY = true;

                    if (!USD.equals("")) {
                        validUSD = validation("USD", USD, customer.getSavingAccount(), label_4, currencyNameList, currencyNumberList);
                    }

                    if (!GBP.equals("")) {
                        validGBP = validation("GBP", GBP, customer.getSavingAccount(), label_5, currencyNameList, currencyNumberList);
                    }

                    if (!EUR.equals("")) {
                        validEUR = validation("EUR", EUR, customer.getSavingAccount(), label_6, currencyNameList, currencyNumberList);
                    }

                    if (!CNY.equals("")) {
                        validCNY = validation("CNY", CNY, customer.getSavingAccount(), label_7, currencyNameList, currencyNumberList);
                    }

                    if (validUSD && validGBP && validEUR && validCNY) { // // the transfer numbers are valid
                        String transferInfo = "";

                        int oriFreeTransferChance = customer.getFreeTransferChance();
                        // transfer fee
                        if (oriFreeTransferChance == 0) {
                            customer.getSavingAccount().deductBalanceByKey("USD", "10");
                            String feeInfo = "The free chances for transfers from the saving account to the checking account have been used up, \n" +
                                    "so you will be charged a fee of 10 USD.";
                            JOptionPane.showInternalMessageDialog(null, feeInfo, "Info", JOptionPane.INFORMATION_MESSAGE);
                            // update table
                            tableS.setTableValue(customer.getSavingAccount().getBalanceByKey("USD"), 0, 1);
                        } else {
                            customer.setFreeTransferChance(customer.getFreeTransferChance() - 1);
                            String content = String.format("each transfer.  Remaining(%d)", customer.getFreeTransferChance());
                            lblTransfer.setText(content);
                        }

                        for (int i = 0; i < currencyNameList.size(); i++) {
                            // get the money from the saving account
                            String key = currencyNameList.get(i);
                            String decrement = currencyNumberList.get(i);
                            customer.getSavingAccount().deductBalanceByKey(key, decrement);

                            transferInfo += decrement + " " + key + ",";

                            // transfer the money to the checking account
                            String increment = decrement;
                            customer.getCheckingAccount().addBalanceByKey(key, increment);

                            // update two tables
                            int tableRowIndex = tableCurrencyName.indexOf(key);
                            tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey(key), tableRowIndex, 1);
                            tableS.setTableValue(customer.getSavingAccount().getBalanceByKey(key), tableRowIndex, 1);
                        }

                        transferInfo = transferInfo.substring(0, transferInfo.length() - 1);
                        String info = "You have successfully transferred " + transferInfo + " from your saving account to your checking account!";
                        JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);

                        clearSTCField();

                        // update the transactions json file
                        String detailedContent = "Transfer " + transferInfo + " from the saving account to the checking account.";
                        String fee = "/";
                        if (oriFreeTransferChance == 0) {
                            fee = "10 USD";
                        }
                        Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Transfer", detailedContent, fee);
                        try {
                            jsonRW.updateTransactions(transaction);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                } else {
                    String info = "Please enter you transfer number!";
                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnReset_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearSTCLabel();
                clearSTCField();
            }
        });

        btnTransfer_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String receiverName = textField_8.getText();
                if (!receiverName.equals("")) {
                    Customer receiver = null;
                    try {
                        receiver = jsonRW.getCustomerByName(receiverName);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if (receiver != null) {
                        if (!receiver.getName().equals(customer.getName())) {
                            String USD = textField_9.getText();
                            String GBP = textField_10.getText();
                            String EUR = textField_11.getText();
                            String CNY = textField_12.getText();

                            clearPTPLabel();

                            ArrayList<String> currencyNameList = new ArrayList<>();
                            ArrayList<String> currencyNumberList = new ArrayList<>();

                            if (!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
                                // do validation
                                boolean validUSD = true;
                                boolean validGBP = true;
                                boolean validEUR = true;
                                boolean validCNY = true;

                                if (!USD.equals("")) {
                                    validUSD = validation("USD", USD, customer.getCheckingAccount(), label_8, currencyNameList, currencyNumberList);
                                }

                                if (!GBP.equals("")) {
                                    validGBP = validation("GBP", GBP, customer.getCheckingAccount(), label_9, currencyNameList, currencyNumberList);
                                }

                                if (!EUR.equals("")) {
                                    validEUR = validation("EUR", EUR, customer.getCheckingAccount(), label_10, currencyNameList, currencyNumberList);
                                }

                                if (!CNY.equals("")) {
                                    validCNY = validation("CNY", CNY, customer.getCheckingAccount(), label_11, currencyNameList, currencyNumberList);
                                }

                                if (validUSD && validGBP && validEUR && validCNY) {
                                    // transfer fee
                                    customer.getCheckingAccount().deductBalanceByKey("USD", "10");
                                    String feeInfo = "You will be charged a fee of 10 USD.";
                                    JOptionPane.showInternalMessageDialog(null, feeInfo, "Info", JOptionPane.INFORMATION_MESSAGE);
                                    // update table
                                    tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey("USD"), 0, 1);

                                    String transferInfo = "";

                                    for (int i = 0; i < currencyNameList.size(); i++) {
                                        // get the money from the saving account
                                        String key = currencyNameList.get(i);
                                        String decrement = currencyNumberList.get(i);
                                        customer.getCheckingAccount().deductBalanceByKey(key, decrement);

                                        transferInfo += decrement + " " + key + ",";

                                        // transfer the money into the checking account of the receiver
                                        String increment = decrement;
                                        receiver.getCheckingAccount().addBalanceByKey(key, increment);

                                        // update table
                                        int tableRowIndex = tableCurrencyName.indexOf(key);
                                        tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey(key), tableRowIndex, 1);
                                    }

                                    // update the receiver in the json file
                                    try {
                                        jsonRW.updateCustomers(receiver);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }

                                    transferInfo = transferInfo.substring(0, transferInfo.length() - 1);
                                    String info = "You have successfully transferred " + transferInfo + " from your checking account to " +
                                            receiverName + "'s checking account!";
                                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);

                                    clearPTPField();

                                    // update the transactions json file
                                    String detailedContent = "Transfer " + transferInfo + " from the " + customer.getName() + "'s checking account to " +
                                            receiver.getName() + "'s checking account";
                                    Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Transfer", detailedContent, "10 USD");
                                    try {
                                        jsonRW.updateTransactions(transaction);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }


                        } else {
                            String info = "The receiver cannot be yourself!";
                            JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        String info = "The receiver doesn't exist";
                        JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    String info = "Please enter the receiver's name!";
                    JOptionPane.showInternalMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    public boolean validation(String currencyName,
                              String currencyNumber,
                              Account account,
                              JLabel jLabel,
                              ArrayList<String> currencyNameList,
                              ArrayList<String> currencyNumberList) {
        boolean valid = true;
        if (nv.isTransferNumberValid(currencyNumber)) {
            String decrement = currencyNumber;
            String originalValue = account.getBalanceByKey(currencyName);
            if (Double.valueOf(decrement) <= Double.valueOf(originalValue)) {
                currencyNameList.add(currencyName);
                currencyNumberList.add(currencyNumber);
            } else {
                valid = false;
                jLabel.setText("Exceed balance!");
            }
        } else {
            valid = false;
            jLabel.setText("Invalid input!");
        }
        return valid;
    }


    public void clearCTSLabel() {
        label.setText("");
        label_1.setText("");
        label_2.setText("");
        label_3.setText("");
    }

    public void clearCTSField() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
    }

    public void clearSTCLabel() {
        label_4.setText("");
        label_5.setText("");
        label_6.setText("");
        label_7.setText("");
    }

    public void clearSTCField() {
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
    }

    public void clearPTPLabel() {
        label_8.setText("");
        label_9.setText("");
        label_10.setText("");
        label_11.setText("");
    }

    public void clearPTPField() {
        textField_8.setText("");
        textField_9.setText("");
        textField_10.setText("");
        textField_11.setText("");
    }
}

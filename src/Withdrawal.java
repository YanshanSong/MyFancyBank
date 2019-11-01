import javax.swing.*;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * The class is used to control the panel of withdrawal.
 */

public class Withdrawal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

	private Customer customer;
	private NumberValidation nv;
	private JsonRW jsonRW;
	private double withdrawlFeeRate;

	/**
	 * Create the panel.
	 */
	public Withdrawal(Customer customer) throws IOException {
		this.customer = customer;
		nv = new NumberValidation();
		jsonRW = new JsonRW();
		withdrawlFeeRate = 0.0001;

		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Withdrawal");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 10, 97, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Checking Account");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(62, 40, 115, 16);
		add(lblNewLabel_1);
		
		JLabel lblSavingAccount = new JLabel("Saving Account");
		lblSavingAccount.setForeground(Color.BLUE);
		lblSavingAccount.setBounds(331, 40, 97, 16);
		add(lblSavingAccount);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(20, 200, 200, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("USD:");
		lblNewLabel_3.setBounds(15, 30, 36, 16);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(53, 25, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GBP:");
		lblNewLabel_4.setBounds(15, 70, 36, 16);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 65, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("EUR:");
		lblNewLabel_5.setBounds(15, 110, 36, 16);
		panel.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(53, 105, 130, 26);
		panel.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("CNY:");
		lblNewLabel_6.setBounds(15, 150, 36, 16);
		panel.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 145, 130, 26);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setBounds(41, 190, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(41, 230, 117, 29);
		panel.add(btnNewButton_1);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(56, 10, 130, 16);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBounds(56, 50, 130, 16);
		panel.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setBounds(56, 90, 130, 16);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setBounds(56, 130, 130, 16);
		panel.add(label_3);
		
		JLabel lblNewLabel_2 = new JLabel("Please be advised that each withdrawal will be charged a fee of 0.01%.");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(30, 160, 440, 18);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("Please enter the multiple of 100 !");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setBounds(146, 180, 208, 16);
		add(lblNewLabel_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(280, 200, 200, 280);
		add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("USD:");
		lblNewLabel_7.setBounds(15, 30, 36, 16);
		panel_1.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(53, 25, 130, 26);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_8 = new JLabel("GBP:");
		lblNewLabel_8.setBounds(15, 70, 36, 16);
		panel_1.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(53, 65, 130, 26);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_9 = new JLabel("EUR:");
		lblNewLabel_9.setBounds(15, 110, 36, 16);
		panel_1.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(53, 105, 130, 26);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_10 = new JLabel("CNY:");
		lblNewLabel_10.setBounds(15, 150, 36, 16);
		panel_1.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(53, 145, 130, 26);
		panel_1.add(textField_7);
		
		JButton btnNewButton_2 = new JButton("Withdraw");
		btnNewButton_2.setBounds(41, 190, 117, 29);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setBounds(41, 230, 117, 29);
		panel_1.add(btnNewButton_3);
		
		label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		label_4.setBounds(56, 10, 130, 16);
		panel_1.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setForeground(Color.RED);
		label_5.setBounds(56, 50, 130, 16);
		panel_1.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setForeground(Color.RED);
		label_6.setBounds(56, 90, 130, 16);
		panel_1.add(label_6);
		
		label_7 = new JLabel("");
		label_7.setForeground(Color.RED);
		label_7.setBounds(56, 130, 130, 16);
		panel_1.add(label_7);

		// use two tables to show the balance in checking account and saving account respectively
		ArrayList<String>tableCurrencyName = new ArrayList<>();
		tableCurrencyName.add("USD");
		tableCurrencyName.add("GBP");
		tableCurrencyName.add("EUR");
		tableCurrencyName.add("CNY");

		String[] title = {"Currency", "Balance"};
		int dataSize = customer.getCheckingAccount().getAccount().size();
		String[][] data = new String[dataSize][2];
		for(int i = 0; i < dataSize; i++) {
			data[i][0] = tableCurrencyName.get(i);
			data[i][1] = customer.getCheckingAccount().getBalanceByKey(data[i][0]);
		}

		Table tableC = new Table(title, data);
		JScrollPane jScrollPaneC = tableC.generateTable();
		jScrollPaneC.setBounds(20,60,200,100);
		add(jScrollPaneC);

		dataSize = customer.getSavingAccount().getAccount().size();
		for(int i = 0; i < dataSize; i++) {
			data[i][0] = tableCurrencyName.get(i);
			data[i][1] = customer.getSavingAccount().getBalanceByKey(data[i][0]);
		}

		Table tableS = new Table(title, data);
		JScrollPane jScrollPaneS = tableS.generateTable();
		jScrollPaneS.setBounds(280, 60, 200, 100);
		add(jScrollPaneS);
		
		// withdrawal from the checking account
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String USD = textField.getText();
				String GBP = textField_1.getText();
				String EUR = textField_2.getText();
				String CNY = textField_3.getText();

				clearCheckingLabel();

				ArrayList<String>currencyNameList = new ArrayList<>();
				ArrayList<String>currencyNumberList = new ArrayList<>();

				if(!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
					// do validation
					boolean validUSD = true;
					boolean validGBP = true;
					boolean validEUR = true;
					boolean validCNY = true;

					if(!USD.equals("")) {
						validUSD = validation("USD", USD, customer.getCheckingAccount(), label, currencyNameList, currencyNumberList);
					}

					if(!GBP.equals("")) {
						validGBP = validation("GBP", GBP, customer.getCheckingAccount(), label_1, currencyNameList, currencyNumberList);
					}

					if(!EUR.equals("")) {
						validEUR = validation("EUR", EUR, customer.getCheckingAccount(), label_2, currencyNameList, currencyNumberList);
					}

					if(!CNY.equals("")) {
						validCNY = validation("CNY", CNY, customer.getCheckingAccount(), label_3, currencyNameList, currencyNumberList);
					}

					if(validUSD && validGBP && validEUR && validCNY) { // the withdrawal numbers are valid
						String feeInfo = "";
						String withdrawlInfo = "";

						for(int i = 0; i < currencyNameList.size(); i++) {
							String key = currencyNameList.get(i);
							String decrement = currencyNumberList.get(i);
							String fee = String.format("%.2f", Double.valueOf(decrement) * withdrawlFeeRate);

							customer.getCheckingAccount().deductBalanceByKey(key, fee);
							customer.getCheckingAccount().deductBalanceByKey(key, decrement);

							feeInfo += fee + " " + key + ",";
							withdrawlInfo += decrement + " " + key + ",";

							// update the table showing the balance of the checking account
							int tableRowIndex = tableCurrencyName.indexOf(key);
							tableC.setTableValue(customer.getCheckingAccount().getBalanceByKey(key), tableRowIndex, 1);
						}

						feeInfo = feeInfo.substring(0, feeInfo.length()-1);
						String info = "You will be charged a fee of " + feeInfo +".";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
						clearCheckingField();

						withdrawlInfo = withdrawlInfo.substring(0, withdrawlInfo.length()-1);
						info = "You have successfully withdrew " + withdrawlInfo + " from your checking account!";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
						clearCheckingField();

						// update the transactions json file
						String detailedContent = "Withdraw " + withdrawlInfo + " from the checking account.";
						Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Withdrawal", detailedContent, feeInfo);
						try {
							jsonRW.updateTransactions(transaction);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}

				}else{
					String info = "Please enter you withdrawal number!";
					JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearCheckingLabel();
				clearCheckingField();
			}
		});


		// withdrawal from the saving account
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String USD = textField_4.getText();
				String GBP = textField_5.getText();
				String EUR = textField_6.getText();
				String CNY = textField_7.getText();

				clearSavingField();

				ArrayList<String>currencyNameList = new ArrayList<>();
				ArrayList<String>currencyNumberList = new ArrayList<>();

				if(!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
					// do validation
					boolean validUSD = true;
					boolean validGBP = true;
					boolean validEUR = true;
					boolean validCNY = true;

					if(!USD.equals("")) {
						validUSD = validation("USD", USD, customer.getSavingAccount(), label_4, currencyNameList, currencyNumberList);
					}

					if(!GBP.equals("")) {
						validGBP = validation("GBP", GBP, customer.getSavingAccount(), label_5, currencyNameList, currencyNumberList);
					}

					if(!EUR.equals("")) {
						validEUR = validation("EUR", EUR, customer.getSavingAccount(), label_6, currencyNameList, currencyNumberList);
					}

					if(!CNY.equals("")) {
						validCNY = validation("CNY", CNY, customer.getSavingAccount(), label_7, currencyNameList, currencyNumberList);
					}

					if(validUSD && validGBP && validEUR && validCNY) { // the withdrawal numbers are valid
						String feeInfo = "";
						String withdrawlInfo = "";
						for(int i = 0; i < currencyNameList.size(); i++) {
							String key = currencyNameList.get(i);
							String decrement = currencyNumberList.get(i);
							String fee = String.format("%.2f", Double.valueOf(decrement) * withdrawlFeeRate);

							customer.getSavingAccount().deductBalanceByKey(key, fee);
							customer.getSavingAccount().deductBalanceByKey(key, decrement);

							feeInfo += fee + " " + key + ",";
							withdrawlInfo += decrement + " " + key + ",";

							int tableRowIndex = tableCurrencyName.indexOf(key);
							tableS.setTableValue(customer.getSavingAccount().getBalanceByKey(key), tableRowIndex, 1);
						}

						feeInfo = feeInfo.substring(0, feeInfo.length()-1);
						String info = "You will be charged a fee of " + feeInfo + ".";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);

						withdrawlInfo = withdrawlInfo.substring(0, withdrawlInfo.length()-1);
						info = "You have successfully withdrew " + withdrawlInfo + " from your saving account!";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
						clearSavingField();

						// update the transactions json file
						String detailedContent = "Withdraw " + withdrawlInfo + " from the saving account.";
						Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Withdrawal", detailedContent, feeInfo);
						try {
							jsonRW.updateTransactions(transaction);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}else{
					String info = "Please enter you withdrawal number!";
					JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSavingLabel();
				clearSavingField();
			}
		});
		
	}

	public boolean validation(String currencyName,
							  String currencyNumber,
							  Account account,
							  JLabel label,
							  ArrayList<String>currencyNameList,
							  ArrayList<String>currencyNumberList) {
		boolean valid = true;

		if(nv.isWithdrawalNumberValid(currencyNumber)){
			String decrement = currencyNumber;
			String originalValue = account.getBalanceByKey(currencyName);
			if(Double.valueOf(decrement) <= Double.valueOf(originalValue)) {
				currencyNameList.add(currencyName);
				currencyNumberList.add(currencyNumber);
			}else{
				valid = false;
				label.setText("Exceed balance!");
			}
		}else{
			valid = false;
			label.setText("Invalid input!");
		}
		return valid;
	}

	public void clearCheckingLabel() {
		label.setText("");
		label_1.setText("");
		label_2.setText("");
		label_3.setText("");
	}

	public void clearCheckingField() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	}

	public void clearSavingLabel() {
		label_4.setText("");
		label_5.setText("");
		label_6.setText("");
		label_7.setText("");
	}

	public void clearSavingField() {
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
	}


}

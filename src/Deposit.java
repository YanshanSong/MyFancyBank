import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;

/**
 * The class is used to control the panel of deposit.
 */

public class Deposit extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	private NumberValidation nv;
	private JsonRW jsonRW;

	/**
	 * Create the panel.
	 */
	public Deposit(Customer customer) throws IOException {
		nv = new NumberValidation();
		jsonRW = new JsonRW();

		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(20, 50, 200, 400);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCheckingAccount = new JLabel("Checking Account");
		lblCheckingAccount.setForeground(Color.BLUE);
		lblCheckingAccount.setBounds(41, 6, 120, 16);
		panel.add(lblCheckingAccount);
		
		JLabel lblUSD_C = new JLabel("USD:");
		lblUSD_C.setBounds(15, 60, 36, 16);
		panel.add(lblUSD_C);
		
		textField = new JTextField();
		textField.setBounds(53, 55, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblGBP_C = new JLabel("GBP:");
		lblGBP_C.setBounds(15, 110, 36, 16);
		panel.add(lblGBP_C);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 105, 130, 26);
		panel.add(textField_1);
		
		JLabel lblEUR_C = new JLabel("EUR:");
		lblEUR_C.setBounds(15, 160, 36, 16);
		panel.add(lblEUR_C);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(53, 155, 130, 26);
		panel.add(textField_2);
		
		JLabel lblCNY_C = new JLabel("CNY:");
		lblCNY_C.setBounds(15, 210, 36, 16);
		panel.add(lblCNY_C);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 205, 130, 26);
		panel.add(textField_3);
		
		JButton btnCheckingDeposit = new JButton("Deoposit");
		btnCheckingDeposit.setBounds(41, 260, 117, 29);
		panel.add(btnCheckingDeposit);
		
		JButton btnCheckingReset = new JButton("Reset");
		btnCheckingReset.setBounds(41, 300, 117, 29);
		panel.add(btnCheckingReset);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(56, 38, 130, 16);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(56, 90, 130, 16);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(56, 140, 130, 16);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(56, 190, 130, 16);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setLayout(null);
		panel_1.setBounds(280, 50, 200, 400);
		add(panel_1);
		
		JLabel lblSavingAccount = new JLabel("Saving Account");
		lblSavingAccount.setForeground(Color.BLUE);
		lblSavingAccount.setBounds(53, 6, 97, 16);
		panel_1.add(lblSavingAccount);
		
		JLabel lblUSD_S = new JLabel("USD:");
		lblUSD_S.setBounds(15, 60, 36, 16);
		panel_1.add(lblUSD_S);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(53, 55, 130, 26);
		panel_1.add(textField_4);
		
		JLabel lblGBP_S = new JLabel("GBP:");
		lblGBP_S.setBounds(15, 110, 36, 16);
		panel_1.add(lblGBP_S);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(53, 105, 130, 26);
		panel_1.add(textField_5);
		
		JLabel lblEUR_S = new JLabel("EUR:");
		lblEUR_S.setBounds(15, 160, 36, 16);
		panel_1.add(lblEUR_S);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(53, 155, 130, 26);
		panel_1.add(textField_6);
		
		JLabel lblCNY_S = new JLabel("CNY:");
		lblCNY_S.setBounds(15, 210, 36, 16);
		panel_1.add(lblCNY_S);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(53, 205, 130, 26);
		panel_1.add(textField_7);
		
		JButton btnSavingDeposit = new JButton("Deposit");
		btnSavingDeposit.setBounds(41, 261, 117, 29);
		panel_1.add(btnSavingDeposit);
		
		JButton btnSavingReset = new JButton("Reset");
		btnSavingReset.setBounds(41, 302, 117, 29);
		panel_1.add(btnSavingReset);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(56, 40, 130, 16);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(56, 90, 130, 16);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(56, 140, 130, 16);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(56, 190, 130, 16);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Only when one of the currencies in");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(10, 340, 180, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("your saving account ≥ 10,000");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(10, 355, 190, 16);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblWillYouEnjoy = new JLabel("will it have a daily interest rate of");
		lblWillYouEnjoy.setForeground(Color.RED);
		lblWillYouEnjoy.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblWillYouEnjoy.setBounds(10, 370, 180, 16);
		panel_1.add(lblWillYouEnjoy);
		
		JLabel lblNewLabel_12 = new JLabel("0.005%.");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(10, 385, 180, 16);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_8 = new JLabel("Please enter the multiple of 100 !");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(144, 22, 211, 23);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Deposit");
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(10, 10, 68, 16);
		add(lblNewLabel_9);

		btnCheckingDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String USD = textField.getText();
				String GBP = textField_1.getText();
				String EUR = textField_2.getText();
				String CNY = textField_3.getText();

				clearCheckingLabel();

				ArrayList<String> currencyNameList = new ArrayList<>();
				ArrayList<String> currencyNumberList = new ArrayList<>();

				if(!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
					// do validation
					boolean valid = true;

					if (!USD.equals("")) {
						if (nv.isDepositNumberValid(USD)) {
							currencyNameList.add("USD");
							currencyNumberList.add(USD);
						}else{
							lblNewLabel.setText("Invalid input!");
							valid = false;
						}
					}
					if (!GBP.equals("")) {
						if (nv.isDepositNumberValid(GBP)) {
							currencyNameList.add("GBP");
							currencyNumberList.add(GBP);
						}else{
							lblNewLabel_1.setText("Invalid input!");
							valid = false;
						}
					}
					if (!EUR.equals("")) {
						if (nv.isDepositNumberValid(EUR)) {
							currencyNameList.add("EUR");
							currencyNumberList.add(EUR);
						}else{
							lblNewLabel_2.setText("Invalid input!");
							valid = false;
						}
					}
					if (!CNY.equals("")) {
						if (nv.isDepositNumberValid(CNY)) {
							currencyNameList.add("CNY");
							currencyNumberList.add(CNY);
						}else{
							lblNewLabel_3.setText("Invalid input!");
							valid = false;
						}
					}
					if(valid) { // the deposit numbers are valid
						String depositInfo = "";
						for(int i = 0; i < currencyNameList.size(); i++) {
							// update the checking account;
							String key = currencyNameList.get(i);
							String increment = currencyNumberList.get(i);
							// deposit the money into the checking account
							customer.getCheckingAccount().addBalanceByKey(key, increment);
							depositInfo += increment + " " + key + ",";
						}

						depositInfo = depositInfo.substring(0, depositInfo.length()-1);
						String info = "You have successfully deposited " + depositInfo + " into your checking account!";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
						clearCheckingField();

						// update the transactions json file
						String detailedContent = "Deposit " + depositInfo + " into the checking account.";
						Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Deposit", detailedContent, "/");
						try {
							jsonRW.updateTransactions(transaction);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				} else{
					String info = "Please enter you deposit number!";
					JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnCheckingReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearCheckingLabel();
				clearCheckingField();
			}
		});

		btnSavingDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String USD = textField_4.getText();
				String GBP = textField_5.getText();
				String EUR = textField_6.getText();
				String CNY = textField_7.getText();

				clearSavingLabel();

				ArrayList<String> currencyName = new ArrayList<>();
				ArrayList<String> currencyNumber = new ArrayList<>();

				if(!USD.equals("") || !GBP.equals("") || !EUR.equals("") || !CNY.equals("")) {
					// do validation
					boolean valid = true;

					if (!USD.equals("")) {
						if (nv.isDepositNumberValid(USD)) {
							currencyName.add("USD");
							currencyNumber.add(USD);
						}else{
							lblNewLabel_4.setText("Invalid input!");
							valid = false;
						}
					}
					if (!GBP.equals("")) {
						if (nv.isDepositNumberValid(GBP)) {
							currencyName.add("GBP");
							currencyNumber.add(GBP);
						}else{
							lblNewLabel_5.setText("Invalid input!");
							valid = false;
						}
					}
					if (!EUR.equals("")) {
						if (nv.isDepositNumberValid(EUR)) {
							currencyName.add("EUR");
							currencyNumber.add(EUR);
						}else{
							lblNewLabel_6.setText("Invalid input!");
							valid = false;
						}
					}
					if (!CNY.equals("")) {
						if (nv.isDepositNumberValid(CNY)) {
							currencyName.add("CNY");
							currencyNumber.add(CNY);
						}else{
							lblNewLabel_7.setText("Invalid input!");
							valid = false;
						}
					}
					if(valid) { // the deposit numbers are valid
						String depositInfo = "";
						// update saving account
						for(int i = 0; i < currencyName.size(); i++) {
							String key = currencyName.get(i);
							String increment = currencyNumber.get(i);
							customer.getSavingAccount().addBalanceByKey(key, increment);
							depositInfo += increment + " " + key + ",";
						}
						depositInfo = depositInfo.substring(0, depositInfo.length()-1);
						String info = "You have successfully deposited " +  depositInfo + " into your saving account!";
						JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
						clearSavingField();

						// update the transactions json file
						String detailedContent = "Deposit " + depositInfo + " into the saving account.";
						Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Deposit", detailedContent, "/");
						try {
							jsonRW.updateTransactions(transaction);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				} else{
					String info = "Please enter you deposit number!";
					JOptionPane.showInternalMessageDialog(null, info,"Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnSavingReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearSavingLabel();
				clearSavingField();
			}
		});
	}

	public void clearCheckingLabel() {
		lblNewLabel.setText("");
		lblNewLabel_1.setText("");
		lblNewLabel_2.setText("");
		lblNewLabel_3.setText("");
	}


	public void clearCheckingField() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	}

	public void clearSavingLabel() {
		lblNewLabel_4.setText("");
		lblNewLabel_5.setText("");
		lblNewLabel_6.setText("");
		lblNewLabel_7.setText("");
	}

	public void clearSavingField() {
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
	}
}

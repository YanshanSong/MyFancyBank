import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * The class is used to control the panel of balance inquiry
 */
public class Balance extends JPanel {
	private JTable table;
	private JScrollPane jscrollpane;

	/**
	 * Create the panel.
	 */
	public Balance(Customer customer) {
		setBounds(0, 0, 500, 500);
		setLayout(null);

		// use two tables to show the balance in checking account and saving account respectively
		ArrayList<String> tableCurrencyName = new ArrayList<>();
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
		jScrollPaneC.setBounds(20, 100, 200, 300);
		add(jScrollPaneC);

		dataSize = customer.getSavingAccount().getAccount().size();
		for(int i = 0; i < dataSize; i++) {
			data[i][0] = tableCurrencyName.get(i);
			data[i][1] = customer.getSavingAccount().getBalanceByKey(data[i][0]);
		}

		Table tableS = new Table(title, data);
		JScrollPane jScrollPaneS = tableS.generateTable();
		jScrollPaneS.setBounds(280, 100, 200, 300);
		add(jScrollPaneS);

		JLabel lblCheckingAccount = new JLabel("Checking Account");
		lblCheckingAccount.setForeground(Color.BLUE);
		lblCheckingAccount.setBounds(62, 80, 115, 16);
		add(lblCheckingAccount);

		JLabel lblSavingAccount = new JLabel("Saving Account");
		lblSavingAccount.setForeground(Color.BLUE);
		lblSavingAccount.setBounds(331, 80, 97, 16);
		add(lblSavingAccount);

		JLabel lblNewLabel = new JLabel("Balance");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 10, 68, 16);
		add(lblNewLabel);

	}
}

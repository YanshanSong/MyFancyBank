import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The class is used to control the banker opearing interface.
 */
public class BankerFrame extends JFrame {

	private JPanel contentPane;
	private JsonRW jsonRW;

	/**
	 * Create the frame.
	 */
	public BankerFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the frame centered
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int width = 700;
		int height = 600;
		setBounds(screenWidth/2 - width/2, screenHeight/2 - height/2, width, height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setBounds(223, 543, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(360, 543, 117, 29);
		contentPane.add(btnNewButton_1);

		// table
		jsonRW = new JsonRW();
		ArrayList<Transaction>transactions = jsonRW.getAllTransactions();
		String[] title = {"Date", "Name", "Type", "Detailed Content", "Fee"};
		String[][] data = new String[transactions.size()][5];

		for(int i = 0; i < transactions.size(); i++) {
			data[i][0] = transactions.get(i).getDate();
			data[i][1] = transactions.get(i).getName();
			data[i][2] = transactions.get(i).getType();
			data[i][3] = transactions.get(i).getDetailedContent();
			data[i][4] = transactions.get(i).getFee();
		}

		Table table = new Table(title, data);
		JScrollPane jScrollPane = table.generateTable();
		jScrollPane.setBounds(20, 40, 660, 500);
		table.setColumnWidth(0, 80);
		table.setColumnWidth(1, 60);
		table.setColumnWidth(2, 80);
		table.setColumnWidth(3,340);
		table.setColumnWidth(4, 100);
		getContentPane().add(jScrollPane);
		
		JLabel lblNewLabel = new JLabel("Report");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(324, 20, 52, 16);
		contentPane.add(lblNewLabel);


		// log out and go back to the Sign In interface
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn frame = null;
				try {
					frame = new SignIn();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				frame.setVisible(true);
				dispose();
			}
		});

		// exit the ATM
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}

}

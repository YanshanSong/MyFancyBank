import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The class is used to control the overall arrangement of the customer operating interface.
 * It uses a cardLayout.
 */
public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnEditInfo;
	private JButton btnWithDrawl;
	private JButton btnDeposit;
	private JButton btnBalanceInquiry;
	private JButton btnTransfers;
	private JButton btnLoan;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	private String currentWindow;

	/**
	 * Create the frame.
	 */
	public CustomerFrame(Customer customer) throws ParseException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		currentWindow = "";
		
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
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(28, 35, 135, 500);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEditInfo = new JButton("Edit Info");
		panel.add(btnEditInfo);
		
		btnWithDrawl = new JButton("Withdrawal");
		panel.add(btnWithDrawl);
		
		btnDeposit = new JButton("Deposit");
		panel.add(btnDeposit);
		
		btnBalanceInquiry = new JButton("Balance Inquiry");
		panel.add(btnBalanceInquiry);
		
		btnTransfers = new JButton("Transfers");
		panel.add(btnTransfers);
		
		btnLoan = new JButton("Loan");
		panel.add(btnLoan);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(54, 6, 82, 22);
		contentPane.add(lblWelcome);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblWelcome.setForeground(Color.BLUE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(175, 35, 500, 500);
		contentPane.add(panel_1);
		CardLayout card = new CardLayout();
		panel_1.setLayout(card);

		HomePage homePage = new HomePage();
		panel_1.add(homePage, "HomePage");
		
		btnNewButton = new JButton("Log Out");
		btnNewButton.setBounds(290, 543, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(445, 543, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("add 10 days' interest");
		btnNewButton_2.setBounds(347, 6, 156, 29);
		contentPane.add(btnNewButton_2);

		// check whether it is a new month
		// If it is a new month, then reset the free chances for transfers from a saving account to a checking account
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		int storedCurrentMonth = customer.getCurrentMonth();
		if(currentMonth != storedCurrentMonth) {
			customer.setCurrentMonth(currentMonth);
			customer.setFreeTransferChance(3);
		}

		// calculate the interest of balance in the saving account and the interest of loan
		// then update the customer's saving account and loan information
		Interest interest = new Interest(customer);
		interest.calculateInterest();

		// open account fee
		if(!customer.getAccountOpenFee()) {
			String remainder = "It is the first time you have deposited money, " +
					"so you will be charged an account open fee of 20 USD.";
			JOptionPane.showInternalMessageDialog(null, remainder, "Info", JOptionPane.INFORMATION_MESSAGE);
			customer.getCheckingAccount().deductBalanceByKey("USD", "20");
			customer.setAccountOpenFee(true);

			Transaction transaction = new Transaction(customer.getOperatingDate(), customer.getName(), "Open Account", "Open an account", "20 USD");
			JsonRW jsonRW = new JsonRW();
			jsonRW.updateTransactions(transaction);
		}

		btnEditInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnEditInfo.setForeground(Color.BLUE);

				Edit edit = null;
				try {
					edit = new Edit(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				currentWindow = "Edit";
				panel_1.add(edit, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});

		btnWithDrawl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnWithDrawl.setForeground(Color.BLUE);
				Withdrawal withdrawal = null;
				try {
					withdrawal = new Withdrawal(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				currentWindow = "Withdrawal";
				panel_1.add(withdrawal, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});

		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnDeposit.setForeground(Color.BLUE);
				Deposit deposit = null;
				try {
					deposit = new Deposit(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				currentWindow = "Deposit";
				panel_1.add(deposit, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});
		
		btnBalanceInquiry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnBalanceInquiry.setForeground(Color.BLUE);
				Balance balance = new Balance(customer);
				currentWindow = "Balance";
				panel_1.add(balance, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});

		btnTransfers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnTransfers.setForeground(Color.BLUE);
				Transfers transfers = null;
				try {
					transfers = new Transfers(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				currentWindow = "Transfers";
				panel_1.add(transfers, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});

		btnLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetButtonColor();
				btnLoan.setForeground(Color.BLUE);
				LoanPanel loanPanel = null;
				try {
					loanPanel = new LoanPanel(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				currentWindow = "Loan";
				panel_1.add(loanPanel, currentWindow);
				card.show(panel_1, currentWindow);
			}
		});


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// update the json file
				try {
					JsonRW jsonRw = new JsonRW();
					jsonRw.updateCustomers(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// update the json file
				try {
					JsonRW jsonRw = new JsonRW();
					jsonRw.updateCustomers(customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		// add 10 days' interest
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interest.calculateInterestByDaySpan(10);

				if(currentWindow.equals("Withdrawal")) {
					Withdrawal withdrawal = null;
					try {
						withdrawal = new Withdrawal(customer);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					panel_1.add(withdrawal, currentWindow);
					card.show(panel_1, currentWindow);
				}

				if(currentWindow.equals("Balance")) {
					Balance balance = new Balance(customer);
					panel_1.add(balance, currentWindow);
					card.show(panel_1, currentWindow);
				}

				if(currentWindow.equals("Transfers")) {
					Transfers transfers = null;
					try {
						transfers = new Transfers(customer);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					panel_1.add(transfers, currentWindow);
					card.show(panel_1, currentWindow);
				}

				if(currentWindow.equals("Loan")) {
					LoanPanel loanPanel = null;
					try {
						loanPanel = new LoanPanel(customer);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					panel_1.add(loanPanel, currentWindow);
					card.show(panel_1, currentWindow);
				}
			}
		});

		// log out and go back to the Sign In interface
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public void resetButtonColor() {
		btnEditInfo.setForeground(Color.BLACK);
		btnWithDrawl.setForeground(Color.BLACK);
		btnDeposit.setForeground(Color.BLACK);
		btnBalanceInquiry.setForeground(Color.BLACK);
		btnTransfers.setForeground(Color.BLACK);
		btnLoan.setForeground(Color.BLACK);
	}
}



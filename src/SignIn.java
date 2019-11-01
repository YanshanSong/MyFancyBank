import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.border.LineBorder;

/**
 * The class is used to control the interface of signing up and signing in.
 * It uses a cardLayout.
 */

public class SignIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SignIn() throws IOException {
		setTitle("Bank ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the frame centered
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int width = 600;
		int height = 400;
		setBounds(screenWidth/2 - width/2, screenHeight/2 - height/2, width, height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 39);
		contentPane.add(panel);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Customer Sign In");
		btnNewButton.setForeground(Color.BLUE);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customer Sign Up");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Banker Login in");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 39, 600, 339);
		contentPane.add(panel_1);
		CardLayout card = new CardLayout();
		panel_1.setLayout(card);
		
		CustomerSignIn customerSignIn = new CustomerSignIn(SignIn.this);
		panel_1.add(customerSignIn, "CustomerSignIn");
		
		CustomerSignUp customerSignUp = new CustomerSignUp();
		panel_1.add(customerSignUp, "CustomerSignUp");
		
		BankerSignIn bankerSignIn = new BankerSignIn(SignIn.this);
		panel_1.add(bankerSignIn, "BankerSignIn");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.show(panel_1, "CustomerSignIn");
				customerSignIn.clearLabel();
				customerSignIn.clearField();
				btnNewButton.setForeground(Color.BLUE);
				btnNewButton_1.setForeground(Color.BLACK);
				btnNewButton_2.setForeground(Color.BLACK);
			}
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.show(panel_1, "CustomerSignUp");
				customerSignUp.clearLabel();
				customerSignUp.clearField();
				btnNewButton_1.setForeground(Color.BLUE);
				btnNewButton.setForeground(Color.BLACK);
				btnNewButton_2.setForeground(Color.BLACK);
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.show(panel_1, "BankerSignIn");
				bankerSignIn.clearLabel();
				bankerSignIn.clearField();
				btnNewButton_2.setForeground(Color.BLUE);
				btnNewButton_1.setForeground(Color.BLACK);
				btnNewButton.setForeground(Color.BLACK);
			}
		});
	}
}

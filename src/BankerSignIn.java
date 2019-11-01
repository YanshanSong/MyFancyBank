import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * The class is used to control the interface of banker signing in.
 */

public class BankerSignIn extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	private JLabel label;
	private JLabel label_1;

	private JsonRW jsonRW;
	
	/**
	 * Create the panel.
	 */
	public BankerSignIn(SignIn signIn) throws IOException {
		jsonRW = new JsonRW();

		setLayout(null);
		setBounds(0, 0, 600, 339);
		
		JLabel lblNewLabel = new JLabel("Banker:");
		lblNewLabel.setBounds(138, 80, 61, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(250, 75, 228, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(138, 158, 81, 16);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(164, 242, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(303, 242, 117, 29);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("For banker");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(6, 0, 167, 26);
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 153, 228, 26);
		add(passwordField);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(250, 58, 228, 16);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBounds(250, 138, 228, 16);
		add(label_1);

		// the banker signs in
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearLabel();

				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());

				Banker banker = null;
				try {
					banker = jsonRW.getBanker();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				if(!name.equals("")) {
					if(!password.equals("")) {
						if(name.equals(banker.getName())) {
							if(password.equals(banker.getPassword())) { // successfully Sign In
								BankerFrame bankerFrame = null;
								try {
									bankerFrame = new BankerFrame();
								} catch (IOException ex) {
									ex.printStackTrace();
								}
								bankerFrame.setVisible(true);
								// close the Sign In windoww
								signIn.dispose();
							}else{
								label_1.setText("Password is wrong!");
							}
						}else{
							label.setText("Name is wrong!");
						}
					}else{
						label_1.setText("Password is empty!");
					}
				}else{
					label.setText("Name is empty!");
				}
			}
		});

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearLabel();
				clearField();
			}
		});
	}

	public void clearLabel() {
		label.setText("");
		label_1.setText("");
	}

	public void clearField() {
		textField.setText("");
		passwordField.setText("");
	}
}

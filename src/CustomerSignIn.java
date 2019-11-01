import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

/**
 * The class is used to control the interface of customer signing in.
 */

public class CustomerSignIn extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	private JsonRW jsonRW;

	/**
	 * Create the panel.
	 */
	public CustomerSignIn(SignIn signIn) throws IOException {
		jsonRW = new JsonRW();
		setLayout(null);
		setBounds(0, 0, 600, 339);
		
		JLabel lblNewLabel = new JLabel("Name:");
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// get the name input by the customer
				String name = textField.getText();
				// get the password input by the customer
				String password = String.valueOf(passwordField.getPassword());
				// do validation
				clearLabel();
				if(!name.equals("")) {
					try {
						Customer customer = jsonRW.getCustomerByName(name);;
						if(customer == null) {
							lblNewLabel_3.setText("The user doesn't exist");
						}else {
							if(!password.equals("")) {
								// logic in successfully
								if(password.equals(customer.getPassword())) {
									CustomerFrame customerFrame = new CustomerFrame(customer);
									customerFrame.setVisible(true);
									signIn.dispose();
								}else{
									lblNewLabel_4.setText("Password is wrong!");
								}
							}else{
								lblNewLabel_4.setText("Password is empty!");
							}
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
				}else{
					lblNewLabel_3.setText("Name is empty!");
				}
			}
		});
		btnNewButton.setBounds(164, 242, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearLabel();
				clearField();
			}
		});
		btnNewButton_1.setBounds(303, 242, 117, 29);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("For customer");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(6, 0, 167, 26);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(250, 58, 318, 16);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(250, 136, 318, 16);
		add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 153, 228, 26);
		add(passwordField);
	}

	public void clearLabel() {
		lblNewLabel_3.setText("");
		lblNewLabel_4.setText("");
	}

	public void clearField() {
		textField.setText("");
		passwordField.setText("");
	}
}

import javax.swing.*;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class is used to control the interface of customer signing up.
 */

public class CustomerSignUp extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JEditorPane editorPane;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;


	private JsonRW jsonRW;

	/**
	 * Create the panel.
	 */
	public CustomerSignUp() throws IOException {
		jsonRW = new JsonRW();

		setBounds(0, 0, 600, 339);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(133, 18, 40, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(130, 38, 337, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(133, 73, 70, 16);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 93, 337, 26);
		add(passwordField);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(133, 130, 55, 16);
		add(lblAddress);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(133, 150, 337, 71);
		add(editorPane);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(133, 235, 40, 16);
		add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 255, 337, 26);
		add(textField_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// get the name of a customer from the "Name" field
				String name = textField.getText();
				// get the password of a customer from the "Password" field
				String password = String.valueOf(passwordField.getPassword());
				// get the address of a customer from the "address" field
				String address = editorPane.getText();
				// get the email of a customer from the "email" field
				String email = textField_1.getText();

				clearLabel();
				// do validation
				try {
					if(validation(name, password, address, email)) {
						Customer customer = new Customer(name, password, address, email);
						jsonRW.updateCustomers(customer);
						String info = "Congratulations, " + customer.getName() + "! You have successfully created a account! \nNow you can sign in to operate the ATM.";
						JOptionPane.showInternalMessageDialog(null, info,"Congratulations!", JOptionPane.INFORMATION_MESSAGE);
						clearField();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});
		btnSignUp.setBounds(164, 293, 117, 29);
		add(btnSignUp);
		
		JButton btnSignUp_1 = new JButton("Reset");
		btnSignUp_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearLabel();
				clearField();
			}
		});
		btnSignUp_1.setBounds(303, 293, 117, 29);
		add(btnSignUp_1);
		
		JLabel lblNewLabel_2 = new JLabel("For customer");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(6, 0, 167, 26);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.red);
		lblNewLabel_3.setBounds(183, 18, 392, 16);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.red);
		lblNewLabel_4.setBounds(213, 73, 362, 16);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.red);
		lblNewLabel_5.setBounds(198, 130, 377, 16);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.red);
		lblNewLabel_6.setBounds(183, 235, 392, 16);
		add(lblNewLabel_6);
	}

	public boolean validation(String name, String password, String address, String email) throws IOException {
		boolean valid = true;

		if(!name.equals("")) {
			ArrayList<String> customerNames = jsonRW.getCustomersNames();
			if(customerNames.contains(name)){
				lblNewLabel_3.setText("The name you input has exists, please change a new name!");
				valid = false;
			}
		}else{
			lblNewLabel_3.setText("Name is empty!");
			valid = false;
		}

		if(!password.equals("")) {
			if(password.length() < 6) {
				lblNewLabel_4.setText("The password you input is too short!");
				valid = false;
			}
		}else{
			lblNewLabel_4.setText("Password is empty!");
			valid = false;
		}

		if(address.equals("")) {
			lblNewLabel_5.setText("Address is empty!");
			valid = false;
		}

		if(!email.equals("")) {
			String pattern = ".+?\\@.+?\\..+";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(email);
			if(!m.find()) {
				lblNewLabel_6.setText("The email you input is invalid!");
				valid = false;
			}
		}else {
			lblNewLabel_6.setText("Email is empty!");
			valid = false;
		}
		return valid;
	}

	public void clearLabel() {
		lblNewLabel_3.setText("");
		lblNewLabel_4.setText("");
		lblNewLabel_5.setText("");
		lblNewLabel_6.setText("");
	}

	public void clearField() {
		textField.setText("");
		passwordField.setText("");
		editorPane.setText("");
		textField_1.setText("");
	}
}

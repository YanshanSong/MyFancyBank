import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class is used to control the panel of edit.
 */

public class Edit extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	JEditorPane editorPane;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;

	JsonRW jsonRW;
	Customer customer;
	private JLabel lblNewLabel_7;

	/**
	 * Create the panel.
	 */
	public Edit(Customer customer) throws IOException {
		jsonRW = new JsonRW();
		this.customer = customer;

		setBounds(0, 0, 500, 500);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(86, 40, 40, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setText(customer.getName());
		textField.setBounds(83, 60, 337, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Password:");
		lblNewLabel_1.setBounds(86, 100, 95, 16);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 120, 337, 26);
		add(passwordField);
		
		lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(86, 160, 55, 16);
		add(lblNewLabel_2);
		
		editorPane = new JEditorPane();
		editorPane.setText(customer.getAddress());
		editorPane.setBounds(86, 188, 337, 71);
		add(editorPane);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(86, 275, 40, 16);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setText(customer.getEmail());
		textField_1.setBounds(83, 295, 337, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(124, 354, 117, 29);
		add(btnNewButton);
		
		JButton btnResit = new JButton("Resit");
		btnResit.setBounds(254, 354, 117, 29);
		add(btnResit);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(191, 100, 268, 16);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_5.setBounds(151, 160, 307, 16);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(136, 275, 320, 16);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Edit");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBounds(10, 10, 40, 16);
		add(lblNewLabel_7);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newPassword = String.valueOf(passwordField.getPassword());
				String address = editorPane.getText();
				String email = textField_1.getText();

				// do validation
				clearLabel();

				boolean valid = validation(newPassword, address, email);

				if(valid) { // the information input is valid
					customer.setPassword(newPassword);
					customer.setAddress(address);
					customer.setEmail(email);
					try { // update customer in the json file
						jsonRW.updateCustomers(customer);
						String info = customer.getName() + ", you have successfully edited your personal information";
						JOptionPane.showInternalMessageDialog(null, info,"Congratulations!", JOptionPane.INFORMATION_MESSAGE);
						clearField();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		btnResit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearLabel();
				clearField();
			}
		});
	}

	public boolean validation(String newPassword, String address, String email) {
		boolean valid = true;
		if(!newPassword.equals("")) {
			lblNewLabel_4.setText("The password you input is too short!");
			valid = false;
		}else{
			lblNewLabel_4.setText("Password is empty!");
			valid = false;
		}

		if(address.equals("")) {
			lblNewLabel_5.setText("Address is empty!");
			valid = false;
		}

		if(!email.equals("")) {
			String pattern = "(.+?)\\@(.+?\\..+)";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(email);
			if(!m.find()) {
				lblNewLabel_6.setText("The email you input is invalid!");
				valid = false;
			}
		}else{
			lblNewLabel_6.setText("Email is empty!");
			return false;
		}
		 return valid;
	}

	public void clearLabel() {
		lblNewLabel_4.setText("");
		lblNewLabel_5.setText("");
		lblNewLabel_6.setText("");
	}

	public void clearField() {
		passwordField.setText("");
		editorPane.setText(customer.getAddress());
		textField_1.setText(customer.getEmail());
	}
}

import javax.swing.*;
import java.awt.*;

/**
 * The class is used to control the homepage of the customer operating interface.
 */
public class HomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePage() {
	    int width = 500;
	    int height = 500;

		setBounds(0, 0, width, height);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		String imagePath = System.getProperty("user.dir") + "/src/image/bank.png";
		ImageIcon imageIcon = new ImageIcon(imagePath);
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds((width-200)/2, (height-200)/2, 200, 200);
	}
}

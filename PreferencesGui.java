import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Preferences page will allow teh suer to change their username or password.
 * 
 * This class extends JDialog so we are able to use the JFrame to add items to the window.
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */

public class PreferencesGui extends JFrame {
	
	/*
	 * Declare buttons to open pages to allow the user to change their details or
	 * to change their password. Also declare labels to explain what the buttons do, so the
	 * user knows what they are changing.
	 */
	
	private JButton chgPassBtn, chgDetBtn;
	private JLabel chgPassLab, chgDetLab;
	
	/*
	 * Constructor
	 * Set the container name to pane, so we can add panels to the window. The layout
	 * of the window will be set to a grid layout, with 2 rows, 2 columns adn a padding of 2
	 */
	
	public PreferencesGui() {
		Container pane = this.getContentPane();
		pane.setLayout(new GridLayout(2, 2, 2, 2));
		
		/*
		 * Top Panel - Change Password Button
		 * 
		 * open page to allow teh user to change password
		 */
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 2, 2, 2));
		
		chgPassBtn = new JButton("Password");
		top.add(chgPassBtn);
		
		chgPassLab = new JLabel("Change Password", SwingConstants.CENTER);
		top.add(chgPassLab);
		
		pane.add(top);
		
		/*
		 * Bottom panel - change details button
		 * 
		 * open page to allow the user to change their details
		 */
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 2, 2, 2));
		
		chgDetBtn = new JButton("Details");
		bottom.add(chgDetBtn);
		
		chgDetLab = new JLabel("Change Details", SwingConstants.CENTER);
		bottom.add(chgDetLab);
		
		pane.add(bottom);
	}
}

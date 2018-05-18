import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This page will feature a prompt to ask the user if they are sure they want
 * to log out. They can either choose yes or no. If they choose yes the system will log
 * the user out and open up the login window again. If the user chooses no, it will clsoe the logout 
 * window and allow the suer to continue where they left off.
 * 
 * This class extends JDialog so we are able to use the JDialog class as a super class.
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */

public class LogoutGui extends JDialog {
	
	/*
	 * Declare variables for a logout prompt which will ask the user if they are sure,
	 * and two buttons one which says yes and one which says no.
	 */
	
	private JLabel logout;
	private JButton yes, no;
	
	/*
	 * Constructor will take the argument JFrame frame
	 * The super will take the JDialog class
	 */
	
	public LogoutGui(JFrame frame) {
		super(frame, "Logout", true);
		setLayout(new FlowLayout());
		
		/*
		 * Add a label which asks the user are they sure they would like to logout
		 */
		
		logout = new JLabel("Are you sure?");
		add(logout);
		
		/*
		 * Yes button for if the user would like to logout
		 */
		
		yes = new JButton("Yes");
		add(yes);
		
		/*
		 * No button for if the user would like to stay logged in
		 */
		
		no = new JButton("No");
		add(no);
		
		/*
		 * add action listeners to each of the buttons and declare classes which will be 
		 * called later on when the button is pressed
		 */
		
		LogoutYes ly = new LogoutYes();
		yes.addActionListener(ly);
		
		LogoutNo ln = new LogoutNo();
		no.addActionListener(ln);
	}
	
	/*
	 * If the user chooses they would like to logout the system will log the user out and open
	 * the login in page for another user to login to the program.
	 */
	
	public class LogoutYes implements ActionListener {
		public void actionPerformed(ActionEvent ly) {
			dispose();
			LoginForm gui = new LoginForm();
	        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        gui.setTitle("Capytec Login");
	        gui.setVisible(true);
	        gui.setSize(375, 135);
	        gui.setLocationRelativeTo(null);
		}
	}
	
	/*
	 * If the user chooses they would not like to logout, the system will take the user back to
	 * where they were so they can carry on where they left off. It will dispose the window,
	 * that way it will not take up memory and will not just be hidden until it is called again
	 */
	
	public class LogoutNo implements ActionListener {
		public void actionPerformed(ActionEvent ln) {
			dispose();
			MainMenu gui = new MainMenu();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(300, 400);
            gui.setLocationRelativeTo(null);
            gui.setTitle("Capytec Main Menu");
            gui.setVisible(true);
		}
	}
}

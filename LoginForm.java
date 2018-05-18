import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import javax.swing.*;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * GUI of login page. Allow functionality to type username and password, login button
 * will login user if details are correct and proceed to main menu page.
 * 
 * @author Jamie Lee Fleming
 * @version 1.0.0
   */
  
public class LoginForm extends JFrame {
    /*
     * Declare variables for a login button; username and password text field;
     * username and password prompt labels; and prompts for if the username
     * and password are incorrect.
     */
    
    private JButton login;
    private JTextField username;
    private JPasswordField password;
    private JLabel usernamePrompt, passwordPrompt, incorrectInfo;
    
    private String driver = "jdbc:sqlite:";
    private String dBase = "C:\\Users\\flemi\\Documents\\folder\\capytec.db";
    private String url = driver+dBase;
    protected Connection conn = null;
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /*
     * Constructor.
     * Layout will be set to a grid layout of 3 rows and 1 columns with a padding of 2.
     * All the panels will be grid layout with 1 row and 2 columns that will take the prompts
     * and text fields
     */
    
    public LoginForm() {
    	 Container pane = this.getContentPane();
         pane.setLayout(new GridLayout(3, 1, 2, 2));
         
         /*
          * Top panel layout - Username
          * On the left will be a prompt asking the user for their username, on the right there
          * will be a textfield which will take the user input for the suername. These are added to
          * the top panel so that they are at the top of the window.
          */
         
         JPanel top = new JPanel();
         top.setLayout(new GridLayout(1, 2));
         
         usernamePrompt = new JLabel("Username: ");
         top.add(usernamePrompt);
         
         username = new JTextField(10);
         top.add(username);
         
         pane.add(top);
         
         /*
          * Middle panel layout - Password
          * On the left is the prompt for the user to enter there password, on the left is the
          * text field in which the user is able to type their password into. These are added to middle
          * panel so they appear in the middle of the window.
          */
         
         JPanel middle = new JPanel();
         middle.setLayout(new GridLayout(1, 2));
         
         passwordPrompt = new JLabel("Password: ");
         middle.add(passwordPrompt);
         
         password = new JPasswordField();
         middle.add(password);
         
         pane.add(middle);
         
         /*
          * Bottom panel layout - Login button
          * The bottom layer consists of 1 JButton which will be a login button. This button has an
          * action listener which will call a class that will enable the user to either login or be
          * told they have entered the incorrect details.
          * The login button is positioned to the left of the window while the right side is left blank
          * If the user enters incorrect information, then a message will appear on the right hand side of the 
          * window next to the login button prompting the user they must try again.
          */
         
         JPanel bottom = new JPanel();
         bottom.setLayout(new GridLayout(1, 2));
         
         login = new JButton("Login");
         bottom.add(login);
         
         incorrectInfo = new JLabel("", SwingConstants.CENTER);
         bottom.add(incorrectInfo);
         pane.add(bottom);
         
         /*
          * Add action listener to the login button. Declare that we will later create
          * a class that will control the login button, and if details are correct
          * will take the user to a main menu page. Of details are incorrect, a help page will
          * display explaining that the given information is incorrect
          */
         
         LoginButtonClass lbc = new LoginButtonClass();
         login.addActionListener(lbc);
    }
    
    public boolean connect() {
    	try {
    		conn = DriverManager.getConnection(url);
    		System.err.println("Connection Successful \n");
    	} catch (SQLException sqlex) {
    		System.err.println("Connection unsuccessfulz\n" + sqlex.toString());
    		return false;
    	} catch (Exception ex) {
    		System.err.println(ex.toString());
    		return false;
    	}
    	return true;
    }
    
    /*
     * Login button class, which takes the information given by the text fields,and compares it
     * with the details to check to see if the user can log on. If the details are correct, the page
     * will progress to the main menu page, if the details are incorrect
     * a help page will show saying that the details entered are not correct and the user must
     * acknowledge by pressing ok, and try again with their details.
     */
    
    public class LoginButtonClass implements ActionListener {
        public void actionPerformed(ActionEvent lbc) {
        	String sql = "SELECT * FROM user WHERE username=? AND password=?";
        	try {
        		conn = DriverManager.getConnection(url);
        		pst = conn.prepareStatement(sql);
        		pst.setString(1, username.getText());
        		pst.setString(2, password.getText());
        		rs = pst.executeQuery();
        		if(rs.next()) {
        			incorrectInfo.setText("");
        			dispose();
                    MainMenu gui = new MainMenu();
                    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gui.setSize(300, 400);
                    gui.setLocationRelativeTo(null);
                    gui.setTitle("Capytec Main Menu");
                    gui.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(null, "Username and password do not match");
        		}
        	} catch (SQLException | HeadlessException ex) {
        		JOptionPane.showMessageDialog(null, ex);
        	}
        }
    }
    
    
    /*
     * Main method, which will allow the program to run. build the window and show all the components on the screen.
     * The program will exit when the cross is selected, the title is called Capytec Login.
     * First create a gui object, then set the default close operation to dispose the window when it is closed.
     * The title will be capytec lgogin. It is set to visible so it appears on the screen, with a size of 
     * 375 by 135
     */
    
    public static void main(String args[]) {
        LoginForm gui = new LoginForm();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setTitle("Capytec Login");
        gui.setVisible(true);
        gui.setSize(375, 135);
        gui.setLocationRelativeTo(null);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Help page will display information about what each button on the main menu does
 * It will give a brief description of each page. While the help page is active, it 
 * is not possible to control another page until it is closed.
 * 
 * This class extends JDialog so we are able to use the JDialog class as a super class.
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */

public class HelpPage extends JDialog
{
	
	/*
	 * Declare labels for each of the page names, and for the information to be entered into
	 * the page, so when the window opens it is clear to see the information
	 */
	
    private JLabel jobs, staff, completed, logout;
    
    /*
     * Constructor
     * Take the argument JFrame frame, then use the super to call the 
     * JDialog class, with the title of help window.
     * Name the container pane, so we are able to use the GridLayoum, with 4 rows and 1 column.
     * The panes will allow the format to be displayed tidy in a neat order going in order of the 
     * buttons on the main menu.
     * 
     * Each JLabel will take the argument SwingConstants.CENTER to center the text in the middle
     * of the panel.
     */
    
    public HelpPage(JFrame frame) {
        super(frame, "Help Window", true);
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4, 1));
        
        /*
         * The jobs panel will give a brief description of the jobs page. This will be added to the top
         * of the window as the jobs button is the first button on the main menu.
         */
        
        JPanel jobsPanel = new JPanel();
        jobsPanel.setLayout(new GridLayout(1, 1));
        
        jobs = new JLabel("The Jobs page will allow the user to view jobs, and assign "
        		+ "to caretakers. The functionality allows jobs to be added or edited.", SwingConstants.CENTER); 
        jobsPanel.add(jobs);
        pane.add(jobsPanel);
        
        /*
         * The staff panel will give a brief description of the staff page. This will be added as 
         * the second piece of information as it is the second button on the main menu.
         */
        
        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new GridLayout(1, 1));
        
        staff = new JLabel("The staff page shows a list of all staff, and will show "
        		+ "weaknesses and strengths. Funcitonality to add or edit staff is also "
        		+ "within this page.", SwingConstants.CENTER); 
        staffPanel.add(staff);
        pane.add(staffPanel);
        
        /*
         * The completed panel will give a brief description of the completed page. This is the third
         * item as it is the third button on the main menu page.
         */
        
        JPanel completedPanel = new JPanel();
        completedPanel.setLayout(new GridLayout(1, 1));
        
        completed = new JLabel("The reports page will show a report of all completed jobs and "
        		+ "which caretaker has completed the task.", SwingConstants.CENTER); 
        completedPanel.add(completed);
        pane.add(completedPanel);
        
        /*
         * The final panel is the logout panel. This will explain what happens if the logout button
         * is pressed. This is shown at the bottom as the logout button is the last button on theb 
         * main menu page 
         */
        
        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new GridLayout(1, 1));
        
        logout = new JLabel("The logout button allows the user to logout of the system, "
        		+ "so that another user is able to log in", SwingConstants.CENTER); 
        logoutPanel.add(logout);
        pane.add(logoutPanel);
    }
}


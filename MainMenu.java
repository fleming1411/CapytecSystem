import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI for the main menu. Provide functionality to choose from a list of buttons on
 * what page to go to next. jobs takes user to the list of jobs page, and allocation page,
 * staff takes user to the staff page, with their information and their strenghts,
 * completed takes user to the list of completed jobs for the past month, and who has completed those
 * jobs, logout logs the user out of the system.
 * 
 * The menu bar features a file button with a help button, to direct to a page telling the
 * user what each of the following pages will show, preference allows the user to go in and change
 * information about themselves, such as password, logout is another functionality ot logout of the program, and
 * quit logs the user out and closes the program.
 * 
 * This class extends the JFrame class so we can add items to the window
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */

public class MainMenu extends JFrame {
    /*
     * Variables for buttons that will navigate to pages depending on what is selected. There is a menu
     * bar with menu items for help, preferences, logout and quit
     */
    
    private JButton jobs, staff, reports, logout;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem help, preferences, logoutFile, quit;
    
    /*
     * Constructor
     * Layout is set to a grid layout with 4 rows and 1 column. 
     */
    
    public MainMenu() {
        setLayout(new GridLayout(4, 1));
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        file = new JMenu("File");
        menuBar.add(file);
        
        help = new JMenuItem("Help");
        file.add(help);
        
        preferences = new JMenuItem("Preferences");
        file.add(preferences);
        
        logoutFile = new JMenuItem("Logout");
        file.add(logoutFile);
        
        quit = new JMenuItem("Quit");
        file.add(quit);
        
        /*
         * Declare classes that will add functionality to the buttons in the menu. These classes will
         * be created later on in the program. Action listeners are added to each button, which will
         * be used later
         */
        
        MenuHelpClass mhc = new MenuHelpClass();
        help.addActionListener(mhc);
        
        MenuPrefClass mpc = new MenuPrefClass();
        preferences.addActionListener(mpc);
        
        MenuLogoutClass mlc = new MenuLogoutClass();
        logoutFile.addActionListener(mlc);
        
        MenuQuitClass mqc = new MenuQuitClass();
        quit.addActionListener(mqc);
        
        /*
         * Add buttons to the window
         */
        
        jobs = new JButton("Jobs");
        //jobs.setBackground(Color.RED);
        add(jobs);
        
        staff = new JButton("Staff");
        add(staff);
        
        reports = new JButton("Reports");
        add(reports);
        
        logout = new JButton("Logout");
        add(logout);
        
        /*
         * Add action listeners to all the buttons on the screen. Declare classes which
         * will be created later on that will open up the pages linked to the buttons.
         */
        
        JobsButtonClass jbc = new JobsButtonClass();
        jobs.addActionListener(jbc);
        
        StaffButtonClass sbc = new StaffButtonClass();
        staff.addActionListener(sbc);
        
        ReportsButtonClass rbc = new ReportsButtonClass();
        reports.addActionListener(rbc);
        
        LogoutButtonClass lbc = new LogoutButtonClass();
        logout.addActionListener(lbc);
    }
    
    /*
     * Classes for all buttons. Functionality will allow the program to take the user
     * to a new page depending on which button the select. if they choose to logout, the program
     * will take the user back to the login page. If the user quits the program through the file button,
     * the user will be logged out and the whole program will close.
     * 
     * This class will open teh help page
     */
    
    public class MenuHelpClass implements ActionListener {
        public void actionPerformed(ActionEvent mhc) {
            
            HelpPage gui = new HelpPage(MainMenu.this);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setSize(800, 250);
            gui.setLocationRelativeTo(null);
            gui.setTitle("Capytec Help Page");
            gui.setVisible(true);
        }
    }
    
    /*
     * This class will open the preferences page so the user can change their username or password
     */
    
    public class MenuPrefClass implements ActionListener {
        public void actionPerformed(ActionEvent mpc) {
            PreferencesGui gui = new PreferencesGui();
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setVisible(true);
            gui.setSize(300, 150);
            gui.setTitle("Preferences");
            gui.setLocationRelativeTo(null);
        }
    }
    
    /*
     * This class will log the user out. A prompt will open up to make sure hte user is sure they
     * would like to logout.
     */
    
    public class MenuLogoutClass implements ActionListener {
        public void actionPerformed(ActionEvent mlc) {
        	Toolkit.getDefaultToolkit().beep();
            LogoutGui gui = new LogoutGui(MainMenu.this);
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Logout");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
    
    /*
     * This class will clsoe the program entirely. It will log the user out and close the 
     * program.
     */
    
    public class MenuQuitClass implements ActionListener {
        public void actionPerformed(ActionEvent mqc) {
            System.exit(0);
        }
    }
    
    /*
     * This button will open the jobs page.
     */
    
    public class JobsButtonClass implements ActionListener {
        public void actionPerformed(ActionEvent jbc) {
            JobsGui gui = new JobsGui();
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setTitle("Capytec Jobs Page");
            gui.setVisible(true);
        }
    }
    
    /*
     * This button will open the staff page
     */
    
    public class StaffButtonClass implements ActionListener {
        public void actionPerformed(ActionEvent sbc) {
             StaffGui gui = new StaffGui();
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setTitle("Capytec Jobs Page");
            gui.setVisible(true);
        }
    }
    
    /*
     * This button will open the reports page
     */
    
    public class ReportsButtonClass implements ActionListener {
        public void actionPerformed(ActionEvent rbc) {
            ReportsGui gui = new ReportsGui();
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setTitle("Capytec Reports Page");
            gui.setVisible(true);
        }
    }
    
    /*
     * This button will allow the suer to logout. A prompt will appear to ensure the user
     * is sure they would like to logout of the program. 
     */
    
    public class LogoutButtonClass implements ActionListener {
        public void actionPerformed(ActionEvent lbc) {
        	dispose();
        	Toolkit.getDefaultToolkit().beep();
            LogoutGui gui = new LogoutGui(MainMenu.this);
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Logout");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
    
    /*
     * Main method which will build the window and add the buttons.
     */
    
    public static void main(String args[]) {
        MainMenu gui = new MainMenu();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setTitle("Capytec Main Menu");
        gui.setSize(300, 400);
        gui.setLocationRelativeTo(null);
    }
}

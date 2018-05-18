import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 * Show information of all the staff on the system. It will show their surname, forename, 
 * date of birth, address, strengths and weaknesses. This page also allow staff details
 * to be manipulated, added and removed. This page is only accessible for certain members of 
 * staff.
 * 
 * This class extends JFrame so we can add items to the window
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */

public class StaffGui extends JFrame {
	
	/*
	 * Declare variables for a table, menu bar with a file menu. WIthin the file menu we have variables
	 * for adding, editing and removing staff, getting help on the page, logout
	 * and to quit the program entirely
	 */
	
    private JTable table;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem add, edit, remove, help, logout, quit;
    
    /*
     * Constructor
     * Layout of the window si flow layout
     * Set the menu bar, with the file menu added to it. Within the file menu is the menu
     * items to add the staff, and edit, remove, help and quit
     */
    
    public StaffGui() {
        setLayout(new FlowLayout());
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        file = new JMenu("File");
        menuBar.add(file);
        
        add = new JMenuItem("Add");
        file.add(add);
        
        edit = new JMenuItem("Edit");
        file.add(edit);
        
        remove = new JMenuItem("Remove");
        file.add(remove);
        
        help = new JMenuItem("Help");
        file.add(help);
        
        logout = new JMenuItem("Logout");
        file.add(logout);
        
        quit = new JMenuItem("Quit");
        file.add(quit);
        
        /*
         * Add action listeners to each of the buttons, and declare classes which
         * will be used and called when the button is pressed
         */
        
        MenuAddClass mac = new MenuAddClass();
        add.addActionListener(mac);
        
        MenuEditClass mec = new MenuEditClass();
        edit.addActionListener(mec);
       
        MenuRemoveClass mrc = new MenuRemoveClass();
        remove.addActionListener(mrc);
        
        MenuHelpClass mhc = new MenuHelpClass();
        help.addActionListener(mhc);
        
        MenuLogoutClass mlc = new MenuLogoutClass();
        logout.addActionListener(mlc);
        
        MenuQuitClass mqc = new MenuQuitClass();
        quit.addActionListener(mqc);
        
        /*
         * Create a table with six columns, for surname, forenmae, date of birth, 
         * strengths and weaknesses. These can be added and edited within the file menu
         * 
         * TODO: Add functionality to edit this table
         */
        
        Object[] columnNames = {"Surname", "Forename", "DoB", "Address", "Strengths", "Weaknesses"};
        
        Object[][] data = {
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
            {"Doe", "John", "14-11-1995", "Address", "Strength", "Weaknesses"},
        };
        
        /*
         * Default model table used to use checkbox within the table if required. This case
         * uses all string classes for each column currently
         * 
         * TODO: add possible extra funcitonality.
         */
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {
            public Class getColumnClass(int column) {
                switch(column) {
                    case 0:
                    return String.class;
                    case 1:
                    return String.class;
                    case 2:
                    return String.class;
                    case 3:
                    return String.class;
                    case 4:
                    return String.class;
                    default:
                    return String.class;
                }
            }
        };
        
        /*
         * Set dimensions of the table to 850 by 250, and allow the table to fill
         * the height of the window
         * 
         * Aldo add scroll pane for if there is mkore staff than the window can view. This 
         * will allow the user to see more data points that are in the table.
         */
        
        table.setPreferredScrollableViewportSize(new Dimension(850, 250));
        table.setFillsViewportHeight(true);               
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        logout.addActionListener(mlc);
    }
    
    /*
     * Class to allow the user to add new staff members to the table
     */
    
    public class MenuAddClass implements ActionListener {
        public void actionPerformed(ActionEvent mac) {
            
        }
    }
    
    /*
     * Class to allow the user to edit existing staff members in the table
     */
    
    public class MenuEditClass implements ActionListener {
        public void actionPerformed(ActionEvent mec) {
            
        }
    }
    
    /*
     * Class allows the user to remove existing class members from the tbale
     */
    
    public class MenuRemoveClass implements ActionListener {
        public void actionPerformed(ActionEvent mrc) {
            
        }
    }
    
    /*
     * Opens a help page so that the user is able to see help on what to do on
     * the staff page and how to use it
     */
    
    public class MenuHelpClass implements ActionListener {
        public void actionPerformed(ActionEvent mhc) {
            
        }
    }
    
    /*
     * Allows the user to logout. Dialog box will appear asking the user if they are sure they would
     * like to logout, and then prompt with yes or no.
     */
    
    public class MenuLogoutClass implements ActionListener {
        public void actionPerformed(ActionEvent mlc) {
        	Toolkit.getDefaultToolkit().beep();
            LogoutGui gui = new LogoutGui(StaffGui.this);
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Logout");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
    
    /*
     * Allows the user to quit the program. Logout and closes the program entirely
     */
    
    public class MenuQuitClass implements ActionListener {
        public void actionPerformed(ActionEvent mqc) {
            System.exit(0);
        }
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Jobs page will allow the user to see what jobs are on the system, and which caretaker
 * is assigned. If no caretaker is assigned, teh functionality to add a caretaker with a 
 * checkbox is available. Once a caretaker has been chosen, it is not possible to choose
 * another caretaker to do the job.
 * 
 * On this page it is also possible to add/edit/remove jobs, which allows new jobs to be 
 * added, more information to be added about the job, and for jobs to be removed completely.
 * 
 * On the far left of the window is a checkbox to state if the job has been complete. This can 
 * only be checked if there is a caretaker assigned to the job, so it is possible to see if a 
 * job is complete and to see who has completed the job.
 * 
 * This class extends the JFrame class so we are able to add items to the window, using
 * Java Swing.
 * 
 * @author Jamie Lee Fleming
 * @version 1.0.0
 */

public class JobsGui extends JFrame
{
	
	/*
	 * Declare variables for a table, menubar, file button on the menubar and buttons within that
	 * file menu to add, edit, remove, get help, logout or quit the program
	 */
	
    private JTable table;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem add, edit, remove, help, logout, quit;
    
    /*
     * Constructor
     * Layout of the jobs page is flow layout. At the top of the page is a menu bar which will
     * feature a file button that will allow the user to have extra functionality, to either edit 
     * the data within the table or to logout, quit or find out how to use the page.
     */
    
    public JobsGui() {
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
         * Action listeners are added to all the buttons within the file menu. Classes
         * will eb called alter to add functionality to these buttons
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
         * Table which will have columns for completed jobs, job description, and column for
         * each caretaker, who's name will appear the top of the column.
         * The completed column features a checkbox which cannot be checked until a 
         * caretaker has been chosen, so that a user cannot say a job is complete without
         * saying who has completed the job.
         * Each caretaker has a checkbox beneath their name, and in line with the jobs. Once a job
         * has a caretaker selected, it is not possible to add another caretaker, as that job is now
         * taken. That caretaker is then able tos ay whether the job has been compelted or not
         */
        
        Object[] columnNames = {"Complete", "Job", "Care1", "Care2", "Care3", "Care4", "Care5", "Care6"};
        
        Object[][] data = {
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
        };
        
        /*
         * Using the default model table we are able to use checkboxes within the table. 
         * 
         * Create a class to say what each column does. The completed and caretaker columns
         * will have boolean class meaning we can use checkboxes. The job column will be a String
         * class so we can type information in about the job.
         */
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {
            public Class getColumnClass(int column) {
                switch(column) {
                    case 0:
                    return Boolean.class;
                    case 1:
                    return String.class;
                    case 2:
                    return Boolean.class;
                    case 3:
                    return Boolean.class;
                    case 4:
                    return Boolean.class;
                    case 5:
                    return Boolean.class;
                    case 6:
                    return Boolean.class;
                    default:
                    return Boolean.class;
                }
            }
        };
        
        /*
         * Size of the table is 850 by 250, and fills the height of the window.
         * 
         * A scroll pane is added so it is possible to scroll through the jobs which do not
         * fit on the screen. This scroll pane is then added to the table.
         */
        
        table.setPreferredScrollableViewportSize(new Dimension(850, 250));
        table.setFillsViewportHeight(true);               
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    
    /*
     * Class which allows a window to open to add information to add a new job
     * to the table.
     */
    
    public class MenuAddClass implements ActionListener {
        public void actionPerformed(ActionEvent mac) {
            
        }
    }
    
    /*
     * A window will appear with a select box of jobs to be able to edit the information
     * of a job.
     */
    
    public class MenuEditClass implements ActionListener {
        public void actionPerformed(ActionEvent mec) {
            
        }
    }
    
    /*
     * A window will open witha  select box to choose a job to be removed. This is in case
     * there is a mistake and hte job is not needed done for what ever reason.
     */
    
    public class MenuRemoveClass implements ActionListener {
        public void actionPerformed(ActionEvent mrc) {
            
        }
    }
    
    /*
     * A window will appear with information on how to use this page. The help page will
     * be a dialog box which shows all the information needed to know what to do on the page.
     */
    
    public class MenuHelpClass implements ActionListener {
        public void actionPerformed(ActionEvent mhc) {
            
        }
    }
    
    /*
     * The logout button will allow the user to logout of the system. A dialog box will
     * appear to ask the user if they are sure they want to log out before they logout.
     */
    
    public class MenuLogoutClass implements ActionListener {
        public void actionPerformed(ActionEvent mlc) {
        	Toolkit.getDefaultToolkit().beep();
            LogoutGui gui = new LogoutGui(JobsGui.this);
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Logout");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
    
    /*
     * This class will allow the user to quit the entire program. This will log the user
     * out and close all the windows of the program down so they have completely exited
     * the program.
     */
    
    public class MenuQuitClass implements ActionListener {
        public void actionPerformed(ActionEvent mqc) {
            System.exit(0);
        }
    }
}

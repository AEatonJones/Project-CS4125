package UI;

import Business.Information_Managers.ProfileControl;
import Business.Profiles.Cafe;
import Business.Profiles.Employee;
import Business.Profiles.Manager;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import Data.ProfileDB;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import UI.UI;
import java.util.ArrayList;

/**
 *
 * @author hmaug
 */
public class ManagerUI implements UI,ActionListener {
    JFrame window;
    JTextField email;
    JPasswordField password;
    JButton signIn, goBack;
    
    /**
     * Sets up GUI.
     */
    @Override
    public void draw() {
        window = new JFrame("Manager Sign In");
        window.setSize(325, 140);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 2));
        
        input.add(new JLabel("Email:"));
        input.add((email = new JTextField()));
        
        input.add(new JLabel("Password:"));
        input.add((password = new JPasswordField()));
        
        
        window.add("Center", input);
        
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        signIn = new JButton("Sign In");
        signIn.addActionListener(this);
        buttons.add(signIn);
        
        goBack = new JButton("Quit");
        goBack.addActionListener(this);
        buttons.add(goBack);
        
        window.add("South", buttons);
        window.setVisible(true);
    }

    /**
     * Triggers when button is pressed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        String potentialEmail = email.getText();
        String potentialPassword = password.getText();
        
        if(pressed.equals(signIn)) {
            try {
                Profile currentProfile = ProfileControl.verifyProfile(potentialEmail,potentialPassword,3);
                if(currentProfile != null) {
                    new ManagerSelectMode((Manager) currentProfile);
                    this.window.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Information given!");
                }
            } catch (IOException ex) {
                Logger.getLogger(CustomerSignIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(pressed.equals(goBack)){
           System.exit(0);
        }
    }
}

class ManagerSelectMode implements UI {
    //String firstname, String surname, String email, String password, String number, Cafe cafe
    Manager manager = null;
    JFrame window;
    
    /**
     * Constructor which gets the variable manager.
     */
    ManagerSelectMode(Manager manager) {
        this.manager = manager;
        draw();
    }
    
    /**
     * Sets up manager GUI.
     */
    @Override
    public void draw()
    {
        window = new JFrame("Manager UI");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        JLabel title = new JLabel("Welcome to the Manager UI, Manager " + manager.getSurname());
        window.add("North", title);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));
        
        JButton employeeMode = new JButton("Employee Mode");
        employeeMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new EmployeeMenu(manager).draw();
                window.dispose();
            }
        });
        buttons.add(employeeMode);
        
        JButton managerMode = new JButton("Manager Mode");
        managerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                window.dispose();
                new ManagerModeUI().initilizeProfile(manager);
            }
        });
        buttons.add(managerMode);
        
        JButton signOut = new JButton("Sign Out");
        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                manager = null;
                window.dispose();
                new ManagerUI().draw();
            }
        });
        buttons.add(signOut);
        
        window.add("Center", buttons);
        
        window.setVisible(true);
    }
}
    
class ManagerModeUI implements UI{

        JFrame window;
        
        Manager currentManager = null;
        
        /**
         *  Constructor which sets currentManager to manager.
         */
        public void initilizeProfile(Manager manager) {
            currentManager = manager;
            draw();
        }
        
        /**
        * Sets up manager menu GUI
        */
        @Override
        public void draw()
        {
            window = new JFrame("Manager Menu");
            window.setSize(350, 230);
            window.setResizable(false);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
            window.setLayout(new BorderLayout());
            
            JPanel buttons = new JPanel();
            buttons.setLayout(new GridLayout(4,1));
            
            JButton employeeList = new JButton("Cafe Employee List");
            employeeList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    window.dispose();
                    new EmployeeList().initilizeProfile(currentManager);
                }
            });
            buttons.add(employeeList);
                    
            JButton viewCafe = new JButton("View Cafe Profile");
            viewCafe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    new ViewCafeProfile().initilizeProfile(currentManager);
                    window.dispose();
                }
            });
            buttons.add(viewCafe);
            
            JButton createEmployee = new JButton("Create new Employee");
            createEmployee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    window.dispose();
                    new EmployeeCreation(currentManager);
                }
            });
            buttons.add(createEmployee);
            
            JButton back = new JButton("Back");
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    window.dispose();
                    new ManagerSelectMode(currentManager);
                }
            });
            buttons.add(back);
            
            window.add("Center", buttons);
            
            window.setVisible(true);
    }

class EmployeeCreation implements UI,ActionListener {
    JFrame window;
    JTextField firstname, surname, password, email, number;
    JButton register, goBack;
    Manager manager;
    
    /**
     * Constructor which sets manager to manager.
     */
    public EmployeeCreation(Manager manager) {
        this.manager = manager;
        draw();
    }
    
    /**
     * Sets up GUI.
     */
    @Override
    public void draw() {
        window = new JFrame("Register Employee Account");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(5, 2));
        
        input.add(new JLabel("Enter firstname:"));
        input.add((firstname = new JTextField()));
        
        input.add(new JLabel("Enter surname:"));
        input.add((surname = new JTextField()));
        
        input.add(new JLabel("Enter password:"));
        input.add((password = new JTextField()));
        
        input.add(new JLabel("Enter email address:"));
        input.add((email = new JTextField()));
        
        input.add(new JLabel("Enter number:"));
        input.add((number = new JTextField()));
        
        window.add("Center", input);
        
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        register = new JButton("Register");
        register.addActionListener(this);
        buttons.add(register);
        
        goBack = new JButton("Go Back");
        goBack.addActionListener(this);
        buttons.add(goBack);
        
        window.add("South", buttons);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
               
        if(pressed.equals(register)) {         
            String[] employeeDetails = new String[7];
            employeeDetails[0] = firstname.getText();
            employeeDetails[1] = surname.getText();
            employeeDetails[2] = email.getText();
            employeeDetails[3] = password.getText();
            employeeDetails[4] = number.getText();
            employeeDetails[5] = manager.getCafe().getName();
            employeeDetails[6] = manager.getCafe().getAddress();
                    

            try {
                Profile profile = ProfileFactory.createProfile("Employee", employeeDetails);
                ProfileControl.printToFile(employeeDetails,2);
            } catch (IOException ex) {
                Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            new ManagerModeUI().initilizeProfile(manager);
            this.window.dispose();           
        }      
        else if(pressed.equals(goBack)) {
            new ManagerModeUI().initilizeProfile(manager);
            this.window.dispose();
        }
    }
    
}
        
        
        
class EmployeeList implements UI,ActionListener {
        JFrame window;
        JList listOfEmployees;
        JScrollPane scrollPane;
        DefaultListModel orderListModel;
        JButton promoteManager, back;
        Manager currentManager = null;
        ArrayList<String> employee;
        
        /**
        * Constructor which sets current manager to manager.
        */
        public void initilizeProfile(Manager manager) {
            currentManager = manager;
            draw();
        }

        /**
        * Sets up GUI.
        */
        @Override
        public void draw()
        {
            window = new JFrame("List of Cafe Employees");
            window.setLayout(new BorderLayout());
            window.setSize(350, 230);
            window.setResizable(false);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
            
            scrollPane = new JScrollPane();
            JPanel employeePanel = new JPanel();
            JPanel buttonPanel = new JPanel();
            employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.PAGE_AXIS));
            buttonPanel.setLayout(new FlowLayout());
            JScrollPane scrollPane = new JScrollPane();
            orderListModel = new DefaultListModel();
            listOfEmployees = new JList(orderListModel);
            scrollPane.setViewportView(listOfEmployees);
            String cafeName = currentManager.getCafe().getName();
            employee = null;
            try {
                    employee = ProfileControl.obtainEmployeeInfo(cafeName);
                
            } catch (IOException ex) {
                Logger.getLogger(ManagerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0; i < employee.size() ;i++ ){
                orderListModel.addElement(employee.get(i));
            }
            scrollPane.setViewportView(listOfEmployees);
            employeePanel.add(scrollPane);

            promoteManager = new JButton("Promote");
            back = new JButton("Back");
            promoteManager.addActionListener(this);
            back.addActionListener(this);
            buttonPanel.add(promoteManager);
            buttonPanel.add(back);
            window.add("North",employeePanel);
            window.add("South",buttonPanel);
            window.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            JButton pressed = (JButton)e.getSource();
            if(pressed.equals(promoteManager)) {
                int selectedIndex = listOfEmployees.getSelectedIndex();
                String selectedDetails = employee.get(selectedIndex);
                try {
                    boolean isManager = ProfileControl.checkIfManager(selectedDetails);
                    if(!isManager) {
                        ProfileControl.promoteToManager(selectedDetails);
                        JOptionPane.showMessageDialog(null,"Employee has been promoted to manager");
                        window.dispose();
                        new EmployeeList().initilizeProfile(currentManager);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"A Manager cannot be promoted!");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ManagerModeUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(pressed.equals(back)) {
                new ManagerModeUI().initilizeProfile(currentManager);
                this.window.dispose();
                }
            }

        }
    }

class ViewCafeProfile implements UI,ActionListener {
        JFrame window;
        JLabel name, address, email, number;
        JButton goBack;
        Manager manager;
        
        /**
        * Constructor which sets manager to manager.
        */
        public void initilizeProfile(Manager manager) {
            this.manager = manager;
            draw();
        }

        /**
        * Sets up GUI.
        */
        @Override
        public void draw() {       
        window = new JFrame("Cafe Account Info");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());


        JPanel input = new JPanel();
        input.setLayout(new GridLayout(5, 2));

        input.add(new JLabel("Cafe Name:"));
        input.add((name = new JLabel(manager.getCafe().getName())));

        input.add(new JLabel("Address:"));
        input.add((address = new JLabel(manager.getCafe().getAddress())));

        input.add(new JLabel("Email:"));
        input.add((email = new JLabel(manager.getCafe().getEmail())));

        input.add(new JLabel("Cafe Number:"));
        input.add((number = new JLabel(manager.getCafe().getNumber())));

        window.add("Center", input);


        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        goBack = new JButton("Go Back");
        goBack.addActionListener(this);
        buttons.add(goBack);

        window.add("South", buttons);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();

        if(pressed.equals(goBack)) {
            new ManagerModeUI().initilizeProfile(manager);
            this.window.dispose();
            }
        }
}
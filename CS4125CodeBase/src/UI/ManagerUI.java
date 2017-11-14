package UI;

import Business.Profiles.Cafe;
import Business.Profiles.Manager;
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

public class ManagerUI implements UI {
    //String firstname, String surname, String email, String password, String number, Cafe cafe
    Manager manager = null;
    JFrame window;
    
    @Override
    public void draw()
    {
        window = new JFrame("Manager UI");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        Cafe cafe = null;
        try
        {
            cafe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        } catch (IOException ex)
        {
            Logger.getLogger(ManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        manager = new Manager("Harry", "Fredrick", "HF@Boss", "ppp", "555444968", cafe);//this line needs to be changed
        
        JLabel title = new JLabel("Welcome to the Manager UI, Manager " + manager.getSurname());
        window.add("North", title);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));
        
        JButton employeeMode = new JButton("Employee Mode");
        employeeMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                window.dispose();
                new EmployeeUI(manager).draw();
            }
        });
        buttons.add(employeeMode);
        
        JButton managerMode = new JButton("Manager Mode");
        managerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                window.dispose();
                new ManagerModeUI().draw();
            }
        });
        buttons.add(managerMode);
        
        window.add("Center", buttons);
        
        window.setVisible(true);
    }
    
    class ManagerModeUI implements UI{

        JFrame window;
        
        @Override
        public void draw()
        {
            window = new JFrame();
            window.setSize(350, 230);
            window.setResizable(false);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
            window.setLayout(new BorderLayout());
            
            JPanel buttons = new JPanel();
            buttons.setLayout(new GridLayout(3,1));
            
            JButton employeeList = new JButton("Employee List");
            employeeList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    window.dispose();
                    new EmployeeList().draw();
                }
            });
            buttons.add(employeeList);
                    
            JButton viewCafe = new JButton("View Cafe");
            viewCafe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    //View Cafe Profile
                }
            });
            buttons.add(viewCafe);
            
            JButton back = new JButton("Back");
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    window.dispose();
                    new ManagerUI().draw();
                }
            });
            buttons.add(back);
            
            window.add("Center", buttons);
            
            window.setVisible(true);
        }
        
        
        
        class EmployeeList implements UI{
            JFrame window;
            Cafe currentCafe;
            JList listOfEmployees;
            DefaultListModel orderListModel;
            JButton back;

            @Override
            public void draw()
            {
                window = new JFrame("List of Employees");
                window.setLayout(new BorderLayout());
                window.setLocationRelativeTo(null);
                
                JPanel employeePanel = new JPanel();
                employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.PAGE_AXIS));
                
                
                
                JScrollPane scrollPane = new JScrollPane();
                orderListModel = new DefaultListModel();
                listOfEmployees = new JList(orderListModel);
                scrollPane.setViewportView(listOfEmployees);
                orderListModel.addElement();
                
                employeePanel.add(listOfEmployees);
                
                back = new JButton("Back");
                back.addActionListener((ActionListener) this);
                employeePanel.add(back);
                
            }
            
                @Override
                public void actionPerformed(ActionEvent e) {
                JButton pressed = (JButton)e.getSource();
                if(pressed.equals(back)){
                    new ManagerModeUI().draw();
                    this.window.dispose();
                }
            }
            
        }
    }

}

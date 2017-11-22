package UI;

import Business.OrderListing;
import Business.Information_Managers.OrderObserver;
import Business.Information_Managers.ProfileControl;
import Business.Orders.Order;
import Business.Orders.SmallOrder;
import Business.Orders.ToGo;
import Business.Profiles.Cafe;
import Business.Profiles.Employee;
import Business.Profiles.Profile;
import Data.OrderDB;
import Data.ProfileDB;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EmployeeUI implements UI,ActionListener {
    JFrame window;
    JTextField email;
    JPasswordField password;
    JButton signIn, goBack;
    
    /**
    * Sets up GUI.
    */
    @Override
    public void draw() {
        window = new JFrame("Employee Sign In");
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
    * If a button is pressed.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        String potentialEmail = email.getText();
        String potentialPassword = password.getText();
        
        if(pressed.equals(signIn)) {
            try {
                Profile currentProfile = ProfileControl.verifyProfile(potentialEmail,potentialPassword,2);
                if(currentProfile != null) {
                    EmployeeMenu em = new EmployeeMenu((Employee) currentProfile);
                    em.draw();
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
    
class EmployeeMenu implements UI, ActionListener{

    Employee employee;
    JFrame window;
    JButton orderWindow, clockIn, clockOut, logOff;
    
    /**
    * Constructor.
    * @param employee Current employee.
    */
    public EmployeeMenu(Employee employee) {
        this.employee = employee;
    }
    
    /**
    * Sets up GUI.
    */
    @Override
    public void draw()
    {
        window = new JFrame("Main Menu");
        window.setSize(300, 120);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
        
        orderWindow = new JButton("Order Window");
        orderWindow.addActionListener(this);
        orderWindow.setAlignmentX(Component.CENTER_ALIGNMENT);
        window.add("North", orderWindow);
        
        
        JPanel clockButtons = new JPanel();
        clockButtons.setLayout(new FlowLayout());
        
        clockIn = new JButton("Clock-In");
        clockIn.addActionListener(this);
        clockButtons.add(clockIn);
        
        clockOut = new JButton("Clock-Out");
        clockOut.addActionListener(this);
        clockButtons.add(clockOut);
        clockButtons.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        window.add("Center", clockButtons);
        
        
        logOff = new JButton("Log Off");
        logOff.addActionListener(this);
        logOff.setAlignmentX(Component.CENTER_ALIGNMENT);
        window.add("South", logOff);
        
        window.setVisible(true);
    }

    /**
    * If a button is pressed.
    */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton pressed = (JButton) e.getSource();
        
        if(pressed.equals(orderWindow)) {
            if(employee.clockedIn()) {
                EmployeeWindow ew = new EmployeeWindow(employee);
                OrderDB.getInstance().attachObserver(ew);
                ew.draw();
                this.window.dispose();
            }
            
            else {
                JOptionPane.showMessageDialog(null, "Must be clocked-in to view this screen", "WARNING: Must Clock-in", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else if(pressed.equals(clockIn)) {
            employee.clockIn();
        }
        
        else if(pressed.equals(clockOut)) {
            employee.clockOut();
        }
        
        else if(pressed.equals(logOff)) {
            if(employee.clockedOut()) {
                new EmployeeUI().draw();
                window.dispose();
            }
            
            else {
                JOptionPane.showMessageDialog(null, "Must be clocked-out to log off", "WARNING: Must Clock-out", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

class EmployeeWindow implements UI, OrderObserver, ActionListener{

    JFrame window;
    Employee activeEmployee;
    OrderListing orders;
    JComboBox<Order> waiting = new JComboBox<Order>();
    JComboBox<Order> ready = new JComboBox<Order>();
    JButton pickOrder, finishOrder, signOut;
    
    /**
    * Constructor.
    * @param Employee The current Employee.
    */
    public EmployeeWindow(Employee Employee){
        activeEmployee =  Employee;
        orders = new OrderListing();
    }
    
    /**
    * Sets up GUI.
    */
    @Override
    public void draw(){
        window = new JFrame("Employee Interface");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        JLabel employeeName = new JLabel(activeEmployee.getFirstName() + " " + activeEmployee.getSurname());
        window.add("North", employeeName);
        
        JPanel orderLists = new JPanel();
        orderLists.setLayout(new FlowLayout());
        
        orderLists.add(waiting);
        orderLists.add(ready);
        
        window.add("Center", orderLists);
        
        Cafe waffe;
        try
        {
            waffe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        
            Data.MenuItem[] items = {new Data.MenuItem(waffe, "Scone", 3.0f, 1)};
            Order order = new SmallOrder(new ToGo(items, "CC"));
            
            waiting.addItem(order);
            
        } catch (IOException ex)
        {
            Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        pickOrder = new JButton("Pick Order");
        pickOrder.addActionListener(this);
        buttons.add(pickOrder);
        finishOrder = new JButton("Finish Order");
        finishOrder.addActionListener(this);
        buttons.add(finishOrder);
        signOut = new JButton("Exit to Menu");
        signOut.addActionListener(this);
        buttons.add(signOut);
        
        window.add("South", buttons);
        
        window.setVisible(true);
    }

    /**
    * Updates waiting and ready lists.
    */
    @Override
    public void update(Order order, String action){
        switch(action.toUpperCase()){
            case("ADD"):waiting.addItem(order); break;
            case("REMOVE"):waiting.removeItem(order); ready.addItem(order); break;
        }
    }

    /**
    * If a button is pressed.
    */
    @Override
    public void actionPerformed(ActionEvent e){
        JButton pressed = (JButton)e.getSource();
        
        if(pressed.equals(pickOrder)){
            Order order = waiting.getItemAt(waiting.getSelectedIndex());
            OrderDB.getInstance().pickOrder(order);
        }
        
        else if(pressed.equals(finishOrder)){
            ready.removeItemAt(ready.getSelectedIndex());
        }
        
        else if(pressed.equals(signOut)){
            new EmployeeMenu(activeEmployee).draw();
            this.window.dispose();
        }
        
    }
}

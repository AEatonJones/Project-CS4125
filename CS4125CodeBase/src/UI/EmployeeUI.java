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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        String potentialEmail = email.getText();
        String potentialPassword = password.getText();
        
        if(pressed.equals(signIn)) {
            try {
                Profile currentProfile = ProfileControl.verifyProfile(potentialEmail,potentialPassword,2);
                if(currentProfile != null) {
                    EmployeeWindow ew = new EmployeeWindow((Employee) currentProfile);
                    OrderDB.getInstance().attachObserver(ew);
                    ew.draw();
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
    


class EmployeeWindow implements UI, OrderObserver, ActionListener{

    JFrame window;
    Employee activeEmployee;
    OrderListing orders;
    JComboBox<Order> waiting = new JComboBox<Order>();
    JComboBox<Order> ready = new JComboBox<Order>();
    JButton pickOrder, finishOrder, signOut;
    
    public EmployeeWindow(Employee Employee){
        activeEmployee =  Employee;
        orders = new OrderListing();
    }
    
    @Override
    public void draw(){
        window = new JFrame("Employee interface");
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
        signOut = new JButton("Sign Out");
        signOut.addActionListener(this);
        buttons.add(signOut);
        
        window.add("South", buttons);
        
        window.setVisible(true);
    }

    @Override
    public void update(Order order, String action){
        switch(action.toUpperCase()){
            case("ADD"):waiting.addItem(order); break;
            case("REMOVE"):waiting.removeItem(order); ready.addItem(order); break;
        }
    }

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
            new EmployeeUI().draw();
            this.window.dispose();
        }
        
    }
}

package UI;

import Business.OrderListing;
import Business.Information_Managers.OrderObserver;
import Business.Orders.Order;
import Business.Orders.SmallOrder;
import Business.Orders.ToGo;
import Business.Profiles.Cafe;
import Business.Profiles.Employee;
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

public class EmployeeUI implements UI, OrderObserver, ActionListener{

    JFrame window;
    Employee activeEmployee;
    OrderListing orders;
    JComboBox<Order> waiting = new JComboBox<Order>();
    JComboBox<Order> ready = new JComboBox<Order>();
    JButton pickOrder, finishOrder, signOut;
    
    public EmployeeUI(Employee activeEmployee){
        this.activeEmployee = activeEmployee;
        orders = new OrderListing();
    }
    
    @Override
    public void draw(){
        window = new JFrame("Employee window");
        window.setSize(350, 230);
        //window.setResizable(false);
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
            //Load signIn Screen
            System.exit(0);
        }
        
    }
}

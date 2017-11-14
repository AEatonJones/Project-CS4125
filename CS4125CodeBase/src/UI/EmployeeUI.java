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
    JList<Order> waiting, ready;
    DefaultListModel<Order> waitingListModel, readyListModel;
    JButton pickOrder, finishOrder, signOut;
    
    public EmployeeUI(Employee activeEmployee){
        this.activeEmployee = activeEmployee;
        orders = new OrderListing();
    }
    
    @Override
    public void draw(){
        window = new JFrame("Employee window");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        JLabel employeeName = new JLabel(activeEmployee.getFirstName() + " " + activeEmployee.getSurname());
        window.add("North", employeeName);
        
        JPanel orderLists = new JPanel();
        orderLists.setLayout(new BorderLayout());
        
        orderLists.add("North", new JLabel("Prepare Queue"));
        waitingListModel = new DefaultListModel<Order>();
        for(Order wOrder : orders.getWaitingOrders())
        {
            waitingListModel.addElement(wOrder);
        }
        Cafe waffe;
        try
        {
            waffe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        
            Data.MenuItem[] items = {new Data.MenuItem(waffe, "Scone", 3.0f, 1)};
            Order order = new SmallOrder(new ToGo(items, "CC"));
            waitingListModel.addElement(order);
            waiting = new JList<Order>(waitingListModel);
            waiting.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            JScrollPane waitingScroll = new JScrollPane();
            waitingScroll.getViewport().setView(waiting);
            orderLists.add(waiting, BorderLayout.EAST);

            orderLists.add(new JLabel("Ready Queue"));
            readyListModel = new DefaultListModel<Order>();
            for(Order rOrder : orders.getReadyOrders())
            {
                readyListModel.addElement(rOrder);
            }
            Data.MenuItem[] itemsR = {new Data.MenuItem(waffe, "Water", 1.5f, 1)};
            Order orderR = new SmallOrder(new ToGo(items, "CC"));
            readyListModel.addElement(order);
            ready = new JList<Order>(readyListModel);
            ready.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            JScrollPane readyScroll = new JScrollPane();
            readyScroll.getViewport().setView(ready);
            orderLists.add(ready, BorderLayout.WEST);

            window.add("Center", orderLists);
        } catch (IOException ex)
        {
            Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        pickOrder = new JButton("Pick Order");
        pickOrder.addActionListener(this);
        buttons.add(pickOrder);
        finishOrder = new JButton("Finish Order");
        finishOrder.addActionListener(this);
        buttons.add(finishOrder);
        signOut = new JButton("Sign Out");
        
        window.add(buttons);
        
        window.setVisible(true);
    }
    
    public void addOrder(Order order)
    {
        waitingListModel = new DefaultListModel<Order>();
        waitingListModel.addElement(order);
        waiting = new JList<Order>(waitingListModel);
    }

    @Override
    public void update(Order order, String action){
        switch(action.toUpperCase()){
            case("ADD"):orders.push(order); window.dispose(); draw(); break;
            case("REMOVE"):orders.pick(order); window.dispose(); draw(); break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton pressed = (JButton)e.getSource();
        
        if(pressed.equals(pickOrder)){
            Order order = waiting.getSelectedValue();
            OrderDB.getInstance().addOrder(order);
        }
        else{
            readyListModel.removeElement(pressed);
        }
        
    }
}

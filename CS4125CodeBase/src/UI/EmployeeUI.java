package UI;

import Business.OrderListing;
import Business.Information_Managers.OrderObserver;
import Business.Orders.Order;
import Business.Profiles.Employee;
import Data.OrderDB;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class EmployeeUI implements UI, OrderObserver, ActionListener{

    JFrame window;
    Employee activeEmployee;
    OrderListing orders;
    JList<OrderButton> waiting, ready;
    
    public EmployeeUI(Employee activeEmployee){
        this.activeEmployee = activeEmployee;
        orders = new OrderListing();
    }
    
    @Override
    public void draw(){
        window = new JFrame("Employee window");
        window.setSize(200, 100);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        
        JLabel employeeName = new JLabel(activeEmployee.getName());
        window.add("North", employeeName);
        
        
        JPanel orderLists = new JPanel();
        orderLists.setLayout(new GridLayout(2, 1));
        
        DefaultListModel<OrderButton> waitingListModel = new DefaultListModel<OrderButton>();
        for(Order wOrder : orders.getWaitingOrders())
        {
            waitingListModel.addElement(new OrderButton(this, wOrder));
        }
        waiting = new JList<OrderButton>(waitingListModel);
        JScrollPane waitingScroll = new JScrollPane();
        waitingScroll.getViewport().setView(waiting);
        orderLists.add(waiting);
        
        DefaultListModel<OrderButton> readyListModel = new DefaultListModel<OrderButton>();
        for(Order rOrder : orders.getWaitingOrders())
        {
            readyListModel.addElement(new OrderButton(this, rOrder));
        }
        ready = new JList<OrderButton>(readyListModel);
        JScrollPane readyScroll = new JScrollPane();
        readyScroll.getViewport().setView(ready);
        orderLists.add(ready);
        
        window.add("Center", orderLists);
        
        
        window.setVisible(true);
    }

    @Override
    public void update(Order order, String action){
        switch(action.toUpperCase()){
            case("ADD"):orders.push(order); window.dispose(); draw(); break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        OrderButton pressed = (OrderButton)e.getSource();
        /*
        if(/*pressed is in waiting){
            
        }
        else/*pressed is in ready{
            
        }
        */
    }
    
    class OrderButton extends JButton
    {
        private Order order;
        
        public OrderButton(ActionListener actionListener, Order order)
        {
            this.order = order;
            this.setText(order.toString());
            this.addActionListener(actionListener);
        }
        
        @Override
        public String toString(){
            return this.order.getDetails();
        }
    }
}

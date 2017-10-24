package UI;

import Business.Information_Managers.OrderObserver;
import Business.Order;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class OrderUI implements UI, OrderObserver{

    ArrayList<Order> orders;
    
    @Override
    public void update(Order order, String action)
    {
        switch (action){
            
            case "ADD": orders.add(order);break;
            
            case "DEL": orders.remove(order);break;
            
        }
    }

    @Override
    public void draw()
    {
        JFrame orderWindow = new JFrame("Orders!");
        orderWindow.setLayout(new BorderLayout());
        
    }
    
}

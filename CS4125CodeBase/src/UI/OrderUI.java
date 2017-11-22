package UI;

import Business.Information_Managers.OrderObserver;
import Business.Orders.Order;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class OrderUI implements UI, OrderObserver{

    ArrayList<Order> orders;
    
    /**
    * Adds or removes order.
    * @param order Current order.
    * @param action Which action used.
    */
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
        
    }
    
}

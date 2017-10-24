package UI;

import Business.Information_Managers.OrderObserver;
import Business.Order;
import java.util.ArrayList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

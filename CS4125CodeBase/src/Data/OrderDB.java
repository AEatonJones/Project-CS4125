package Data;

import Business.Information_Managers.OrderObserver;
import Business.Order;
import java.util.ArrayList;

public class OrderDB implements Subject{

    ArrayList<OrderObserver> observers = new ArrayList<OrderObserver>();
    
    @Override
    public void attachObserver(OrderObserver observer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dettachObserver(OrderObserver observer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers(Order order, String action)
    {
        for(OrderObserver observer : observers)
        {
            observer.update(order, action);
        }
    }
    
}

package Data;

import Business.Information_Managers.OrderObserver;
import Business.Order;
import java.util.ArrayList;

public class OrderDB implements Subject{

    private ArrayList<OrderObserver> observers;
    
    
    public OrderDB()
    {
        observers = new ArrayList<OrderObserver>();
    }
    
    public void addOrder(Order order)
    {
        
    }
    
    @Override
    public void attachObserver(OrderObserver observer)
    {
        observers.add(observer);
    }

    @Override
    public void dettachObserver(OrderObserver observer)
    {
        observers.remove(observer);
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

package Data;

import Business.Information_Managers.OrderObserver;
import Business.Order;
import java.util.ArrayList;

public class OrderDB implements Subject{

    ArrayList<OrderObserver> observers = new ArrayList<OrderObserver>();
    
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

package Business.Information_Managers;

import Business.Orders.Order;
import Data.OrderDB;

/**
* Is an interface that is used for updates.
*/
public interface OrderObserver{
    
    public abstract void update(Order order, String action);
    
}

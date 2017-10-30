package Business.Information_Managers;

import Business.Orders.Order;
import Data.OrderDB;

public interface OrderObserver{
    
    public abstract void update(Order order, String action);
    
}

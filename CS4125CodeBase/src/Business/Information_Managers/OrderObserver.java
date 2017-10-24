package Business.Information_Managers;

import Business.Order;
import Data.OrderDB;

public interface OrderObserver{
    
    public abstract void update(Order order, String action);
    
}

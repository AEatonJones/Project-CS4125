package UI;

import Business.OrderListing;
import Business.Information_Managers.OrderObserver;
import Business.Order;

public class EmployeeUI implements UI, OrderObserver{

    OrderListing orders;
    
    
    @Override
    public void draw()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Order order, String action)
    {
        switch(action.toUpperCase()){
            case("ADD"):orders.push(order);
        }
    }
    
}

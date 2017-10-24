package UI;

import Business.Order;
import Data.OrderDB;
import java.util.*;

public class CustomerUI implements UI{

    ArrayList<Order> orders;
    
    public CustomerUI()
    {
        orders = new ArrayList<Order>();
        promptUser();
    }
    
    private void promptUser()
    {
        System.out.println("Select one of the following for your Order:");
        for(int orderCount = 1; orderCount < orders.size();orderCount++)
            System.out.println(orderCount + "):" + orders.get(orderCount - 1));
        
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
    }
    
    @Override
    public void draw()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

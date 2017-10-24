package UI;

import Business.Order;
import Business.Profiles.Cafe;
import Data.OrderDB;
import java.util.*;

public class CustomerUI implements UI{

    Cafe cafe;
    ArrayList<Order> orderChoice;
    
    public CustomerUI(Cafe cafe)
    {
        this.cafe = cafe;
        orderChoice = cafe.getMenu().getChoices();
        promptUser();
    }
    
    private void promptUser()
    {
        System.out.println("Select one of the following for your Order:");
        for(int orderCount = 1; orderCount < orderChoice.size();orderCount++)
            System.out.println(orderCount + "):" + orderChoice.get(orderCount - 1));
        
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        
        OrderDB.getInstance().addOrder(orderChoice.get(choice));
    }
    
    @Override
    public void draw()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

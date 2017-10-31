package UI;

import Business.Orders.Order;
import Business.Orders.ToGo;
import Business.Profiles.Cafe;
import Business.Information_Managers.PaymentControl;
import Data.*;
import java.util.*;

public class CustomerUI implements UI{

    Cafe cafe;
    ArrayList<MenuItem> orderChoice;
    
    public CustomerUI(Cafe cafe)
    {
        this.cafe = cafe;
        orderChoice = cafe.getMenu().getChoices();
        draw();
    }
    
    private void promptUser()
    {
        System.out.println("Select one of the following for your Order:");
        for(int orderCount = 1; orderCount < orderChoice.size();orderCount++)
            System.out.println(orderCount + "):" + orderChoice.get(orderCount - 1));
        
        Scanner input = new Scanner(System.in);
        String choices = input.nextLine();
        String [] choiceArray = choices.split(",");
        MenuItem [] items = new MenuItem[choiceArray.length];
        float totalCost = 0.0f;
        for(int itemCount = 0; itemCount < choiceArray.length; itemCount++)
        {
            items[itemCount] = orderChoice.get(Integer.parseInt(choiceArray[itemCount]));
        }
        

        String paymentType = PaymentControl.getType();
        PaymentControl.validatePayment(paymentType);
        Order order = new ToGo(items,paymentType);
        
        System.out.println("That'll cost you " + order.getCost() + " euro");
        
        
        OrderDB.getInstance().addOrder(order);
    }
    
    @Override
    public void draw()
    {
        promptUser();
    }
    
    
    
}

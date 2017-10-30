package UI;

import Business.OrderListing;
import Business.Information_Managers.OrderObserver;
import Business.Orders.Order;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeUI implements UI, OrderObserver{

    OrderListing orders;
    
    public EmployeeUI(){
        orders = new OrderListing();
        draw();
    }
    
    @Override
    public void draw(){
        promptUser();
    }
    
    public void promptUser(){
        ArrayList<Order> waiting    = orders.getWaitingOrders();
        ArrayList<Order> ready      = orders.getReadyOrders();
        
        String output = "Waiting:\n";
        for(int waitCount = 1; waitCount < waiting.size() + 1; waitCount++)
            output += "\t" + waitCount + "):" + waiting.get(waitCount - 1).toString() + "\n";
        
        output += "\nReady:\n";
        for(int readyCount = 1; readyCount < ready.size() + 1; readyCount++)
            output += ready.get(readyCount - 1).toString() + ", ";
        
        System.out.println(output);
    }

    @Override
    public void update(Order order, String action){
        switch(action.toUpperCase()){
            case("ADD"):orders.push(order); draw(); break;
        }
    }
    
}

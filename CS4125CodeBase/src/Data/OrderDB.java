package Data;

import Business.Information_Managers.OrderObserver;
import Business.Orders.Order;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDB implements Database<Order>, Subject{

    private ArrayList<OrderObserver> observers;
    
    private static OrderDB instance = null;
    
    private OrderDB()
    {
        observers = new ArrayList<OrderObserver>();
    }
    
    public static OrderDB getInstance()
    {
        if(instance == null)
            instance = new OrderDB();
        
        return instance;
    }
    
    public void addOrder(Order order){
        try
        {
            writeToFile(order);
            notifyObservers(order, "ADD");
        } 
        catch (IOException ex)
        {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pickOrder(Order order){
        notifyObservers(order, "REMOVE");
    }
    
    @Override
    public void attachObserver(OrderObserver observer){
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

    @Override
    public void writeToFile(Order data)throws IOException
    {
        File file = new File(".\\src\\Resources\\Orders\\Orders.txt");
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append(data.getDetails());
        
        writer.close();

    }
    
}

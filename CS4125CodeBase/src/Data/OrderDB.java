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
    
    /**
    * Private Constructor used to initialise the instance variable.
    */
    private OrderDB()
    {
        observers = new ArrayList<OrderObserver>();
    }
    
    /**
    * Getter which gets the current order database.
    * @return instance Which is the current order database.
    */
    public static OrderDB getInstance()
    {
        if(instance == null)
            instance = new OrderDB();
        
        return instance;
    }
    
    /**
    * Adds the order to the order database.
    * @param order Current order.
    */
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
    
    /**
    * Removes the order to be made from the order database.
    * @param order Current order.
    */
    public void pickOrder(Order order){
        notifyObservers(order, "REMOVE");
    }
    
    /**
    * 
    */
    @Override
    public void attachObserver(OrderObserver observer){
        observers.add(observer);
    }

    /**
    * 
    */
    @Override
    public void dettachObserver(OrderObserver observer)
    {
        observers.remove(observer);
    }

    /**
    * 
    */
    @Override
    public void notifyObservers(Order order, String action)
    {
        for(OrderObserver observer : observers)
        {
            observer.update(order, action);
        }
    }

    /**
    * 
    */
    @Override
    public void writeToFile(Order data)throws IOException
    {
        File file = new File(".\\src\\Resources\\Orders\\Orders.txt");
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append(data.getDetails());
        
        writer.close();

    }
    
}

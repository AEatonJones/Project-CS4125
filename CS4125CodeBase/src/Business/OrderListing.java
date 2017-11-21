package Business;

import Business.Orders.Order;
import java.util.ArrayList;

/**
 *
 * @author hmaug
 */
public class OrderListing implements Listing<Order>{

    private ArrayList<Order> waiting = new ArrayList<Order>();
    private ArrayList<Order> ready = new ArrayList<Order>();
    
    /**
     * returns the size of the ArrayList named waiting.
     * @return
     */
    public int amountWaiting()
    {
        return waiting.size();
    }
    
    /**
     * returns the size of the ArrayList named ready.
     * @return
     */
    public int amountReady()
    {
        return ready.size();
    }
    
    /**
     *returns the ArrayList named waiting.
     * @return
     */
    public ArrayList<Order> getWaitingOrders(){
        return waiting;
    }
    
    /**
     * returns the ArrayList named waiting.
     * @return
     */
    public ArrayList<Order> getReadyOrders(){
        return ready;
    }
    
    /**
     *
     */
    @Override
    public void sortListing(){
        waiting.sort(null);
    }

    /**
     *
     * @param listItem
     */
    @Override
    public void push(Order listItem){
        waiting.add(listItem);
        sortListing();
    }

    /**
     *
     * @param listItem
     */
    @Override
    public void pick(Order listItem)
    {
        waiting.remove(listItem);
        ready.add(listItem);
    } 
}

package Business;

import Business.Orders.Order;
import java.util.ArrayList;

/**
* Concrete listing of Order type.
*/
public class OrderListing implements Listing<Order>{

    private ArrayList<Order> waiting = new ArrayList<Order>();
    private ArrayList<Order> ready = new ArrayList<Order>();
    
    /**
     * Gets the size of the ArrayList named waiting.
     * @return waiting.size The size of the ArrayList waiting.
     */
    public int amountWaiting()
    {
        return waiting.size();
    }
    
    /**
     * Gets the size of the ArrayList named ready.
     * @return ready.size The size of the ArrayList waiting.
     */
    public int amountReady()
    {
        return ready.size();
    }
    
    /**
     *Gets the ArrayList named waiting.
     * @return waiting The ArrayList waiting.
     */
    public ArrayList<Order> getWaitingOrders(){
        return waiting;
    }
    
    /**
     * Gets the ArrayList named waiting.
     * @return ready The ArrayList ready.
     */
    public ArrayList<Order> getReadyOrders(){
        return ready;
    }
    
    /**
     *Sorts waiting list.
     */
    @Override
    public void sortListing(){
        waiting.sort(null);
    }

    /**
     *Adds Order object to the ArrayList waiting.
     * @param listItem item in Current order.
     */
    @Override
    public void push(Order listItem){
        waiting.add(listItem);
        sortListing();
    }

    /**
     * Transfer Order object from waiting list to ready list.
     * @param listItem item in Current order.
     */
    @Override
    public void pick(Order listItem)
    {
        waiting.remove(listItem);
        ready.add(listItem);
    } 
}

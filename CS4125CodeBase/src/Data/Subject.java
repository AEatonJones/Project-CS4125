package Data;
/**
* The Subject interface allows for dynamic changes of a UI element based on the changing of a source of data.
* The Subject interface provides 2 methods for the relating and releasing of Observer objects to this Subject.
* 
* 
*/
public interface Subject
{
    /**
     * Relate the given observer to this Subject.
     * @param observer The Observer object to be related to this Subject.
     */
    public abstract void attachObserver(Business.Information_Managers.OrderObserver observer);
    
    /**
     * Release the given observer from this Subject.
     * @param observer The Observer object to be removed from this Subject.
     */
    public abstract void dettachObserver(Business.Information_Managers.OrderObserver observer);
    
    /**
     * Interact with every related Observer using the provided data.
     * @param order The Order object
     * @param action The action to take on the given order.
     */
    public abstract void notifyObservers(Business.Orders.Order order, String action);
}

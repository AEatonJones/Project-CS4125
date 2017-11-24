package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem; 

public class SmallOrder extends OrderDecorator 
{
    /**
     * Decorates a given Order object as a small order.
     * @param order Current order.
     */
    public SmallOrder(Order order){
        super(order);
        this.surcharge = 1.25f; 
        this.baseEtf = 1;
    }
    
    /**
     * Gets the cost of the order.
     * @return The cost of the order.
     */
    @Override
    public float getCost(){
        return super.getCost() + surcharge;
    }
    
    /**
     * Gets estimated time of the order.
     * @return The estimated time to finish.
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

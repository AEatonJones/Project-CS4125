package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem; 

public class SmallOrder extends OrderDecorator 
{
    /**
     * gets the items on the order.
     */
    public SmallOrder(Order order){
        super(order);
        this.surcharge = 1.25f; 
        this.baseEtf = 1;
    }
    
    /**
     * gets the cost of the order.
     */
    @Override
    public float getCost(){
        return super.getCost() + surcharge;
    }
    
    /**
     * gets estimated time of the order.
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

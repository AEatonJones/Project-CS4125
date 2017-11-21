package Business.Orders;

import Data.MenuItem; 

public class LargeOrder extends OrderDecorator{
    /**
     * gets all the info of the items in the order.
     */
    public LargeOrder(Order order){
        super(order);
        this.surcharge = 2.5f;
        this.baseEtf = 2;
    }
    /**
     * gets the cost of the entire order.
     */
    @Override
    public float getCost(){
        return super.getCost() + surcharge;
    }
    /**
     * gets estimated time to finish
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

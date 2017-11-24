package Business.Orders;

import Data.MenuItem; 

public class LargeOrder extends OrderDecorator{
    /**
     * Decorates a given Order object as a large order.
     * @param order Current order.
     */
    public LargeOrder(Order order){
        super(order);
        this.surcharge = 2.5f;
        this.baseEtf = 2;
    }
    /**
     * Gets the cost of the entire order.
     */
    @Override
    public float getCost(){
        return super.getCost() + surcharge;
    }
    /**
     * Gets estimated time to finish
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

package Business.Orders;

import Business.Information_Managers.OrderObserver;

public class MediumOrder extends OrderDecorator{
    /**
     * gets all items on the order.
     */
    public MediumOrder(Order order){
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
     * gets estimated time to finish order.
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

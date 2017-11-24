package Business.Orders;

import Business.Information_Managers.OrderObserver;

public class MediumOrder extends OrderDecorator{
    /**
     * Decorates a given Order object as a medium order.
     * @param order Current order.
     */
    public MediumOrder(Order order){
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
     * Gets estimated time to finish order.
     */
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

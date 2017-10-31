package Business.Orders;

import Business.Information_Managers.OrderObserver;

public class MediumOrder extends OrderDecorator{
    
    public MediumOrder(Order order){
        super(order);
        this.surcharge = 2.5f;
        this.baseEtf = 2;
    }
    
    @Override
    public float getCost(){
        return super.getCost() + surcharge;
    }
    
    @Override
    public int getEtf(){
        return super.getEtf() + baseEtf;
    }
}

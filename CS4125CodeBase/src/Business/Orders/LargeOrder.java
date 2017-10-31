package Business.Orders;

import Data.MenuItem; 

public class LargeOrder extends OrderDecorator{
    
    public LargeOrder(Order order){
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

package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem; 

public class SmallOrder extends OrderDecorator 
{
    public SmallOrder(Order order){
        super(order);
        this.surcharge = 1.25f; 
        this.baseEtf = 1;
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

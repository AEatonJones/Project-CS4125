package Business.Orders;
import Data.MenuItem;

public class ToGo extends Order{

    /**
     * 
     */
    public ToGo(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 1.0f;
        this.baseEtf = 1;
        this.paymentType = paymentType;
    }
    /**
     * 
     */
    @Override
    public String getDetails(){
        String result = getCafe().getName() + ", ";
        for(MenuItem item : items)
            result += item.getName() + ", ";
        
        result += getCost();
        
        return result;
    }
}

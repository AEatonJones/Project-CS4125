package Business.Orders;
import Data.MenuItem;

public class ToStay extends Order{

    
    public ToStay(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 0.5f;
        this.baseEtf = 0;
        this.paymentType = paymentType;
    }
    
    @Override
    public String getDetails(){
        String result = getCafe().getName() + ", ";
        System.out.println(items == null);
        for(MenuItem item : items)
            result += item.getName() + ", ";
        
        result += getCost();
        
        return result;
    }
}

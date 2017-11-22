package Business.Orders;
import Data.MenuItem;

public class ToGo extends Order{

    /**
     * Constructor.
     * @param items Menu of items.
     * @param paymentType What form of payment will be used.
     */
    public ToGo(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 1.0f;
        this.baseEtf = 1;
        this.paymentType = paymentType;
    }
    /**
     * Getter which will return the order of items and its cost.
     * @return Result of order which is its items and cost.
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

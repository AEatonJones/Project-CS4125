package Business.Orders;
import Data.MenuItem;

public class ToStay extends Order{

    /**
     * Constructor.
     * @param items Menu of items.
     * @param paymentType What form of payment will be used.
     */
    public ToStay(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 0.5f;
        this.baseEtf = 0;
        this.paymentType = paymentType;
    }
    /**
     * Getter which gets the details of the order.
     * @return Result which is the items and cost of the order.
     */
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

package Business.Orders;
import Data.MenuItem;

public class ToStay extends Order{

    
    public ToStay(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 0.5f;
        this.baseEtf = 0;
        this.paymentType = paymentType;
    }
}

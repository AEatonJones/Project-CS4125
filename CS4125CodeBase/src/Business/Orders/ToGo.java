package Business.Orders;
import Business.Profiles.Cafe;
import Data.MenuItem;

public class ToGo extends Order{

    
    public ToGo(MenuItem[] items, String paymentType){
        this.items = items;
        this.surcharge = 1.0f;
        this.baseEtf = 1;
        this.paymentType = paymentType;
    }
}

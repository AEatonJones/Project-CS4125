package Business.Information_Managers;

import Business.Profiles.Profile;
import Business.Orders.*;
import java.util.*;

public class PaymentControl {
    
    /**
    * Sets the balance of order.
    * @param o Order.
    */
    public void addPaymentToCafe(Order o) {
        o.getCafe().setBalance(o.getCost());
    }

}

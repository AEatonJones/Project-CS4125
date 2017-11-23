package Business.Information_Managers;

import Business.Profiles.Profile;
import Business.Orders.*;
import java.util.*;

public class PaymentControl {
    
    /**
    * Adds payment cost of order to the balance of the cafe associated with it.
    * @param o Order items purchased by customer.
    */
    public void addPaymentToCafe(Order o) {
        o.getCafe().setBalance(o.getCost());
    }

}

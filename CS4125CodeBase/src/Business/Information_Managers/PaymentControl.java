package Business.Information_Managers;

import Business.Profiles.Profile;
import Business.Orders.*;
import java.util.*;

public class PaymentControl {
    
    public void addPaymentToCafe(Order o) {
        o.getCafe().setBalance(o.getCost());
    }

}

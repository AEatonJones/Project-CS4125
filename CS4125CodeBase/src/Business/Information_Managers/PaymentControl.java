package Business.Information_Managers;

import Business.Profiles.Profile;
import Business.Orders.*;
import java.util.*;

public class PaymentControl {
    
    public static String getType(){
        String paymentType = "";
        
        System.out.println("Select payment option (1)Credit card(CC)\n(2)Paypal(PP)\n(3)Cash on arrival(COA): ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        
        return paymentType;
    }
    
    public static boolean validatePayment(String method) {
        boolean valid = false;
        
        if(method.equalsIgnoreCase("CC")) {
          Scanner input = new Scanner(System.in);  
          System.out.println("Enter card number:");
          String cardNumber = input.nextLine();
           
          System.out.println("Enter card expired date:");
          String expiredDate = input.nextLine();
          
          System.out.println("Enter CVV:");
          String cvv = input.nextLine();
          valid = true;
        }
        
        else if(method.equalsIgnoreCase("PP")) {
          Scanner input = new Scanner(System.in);  
          System.out.println("Enter paypal email:");
          String ppEmail = input.nextLine();
           
          System.out.println("Enter paypal password:");
          String ppWord = input.nextLine();  
          valid = true;
        }
        
        else if(method.equalsIgnoreCase("COA")) { 
          System.out.println("Payment will be need on arrival for order!");

          valid = true;
        }
        return valid;
    }
    
    public void addPaymentToCafe(Order o) {
        o.getCafe().setBalance(o.getCost());
    }

}

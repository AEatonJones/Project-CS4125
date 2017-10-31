package Business;

import Business.Profiles.Cafe;
import Data.MenuItem;

public class Order implements Comparable<Order>{
    
    private MenuItem [] menuItems;
    private int etf;
    private String paymentType;
    
    public Order(MenuItem [] menuItems, String paymentType){
        this.menuItems = menuItems;
        this.paymentType = paymentType;
        this.etf = this.menuItems.length * 3;
    }
    
    

    public float getCost() {
        float cost = 0.0f;
        
        for(MenuItem item : menuItems){
            cost += item.getCost();
        }
        
        return cost;
    }
    
    public Cafe getCafe() {
        return menuItems[0].getCafe();
    }

    public int getEtf()
    {
        return etf;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    @Override
    public int compareTo(Order o) {
        int result = 0;
        
        if(this.etf < o.getEtf()){
            result--;
        }
        
        else if(this.etf > o.getEtf()){
            result++;
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        String result = getCafe().getName();
        
        for(MenuItem item : menuItems)
            result += item.getName() + ", " + item.getCost();
        
        return result;
    }
}
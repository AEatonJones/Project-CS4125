package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public abstract class Order implements Comparable<Order>{
    
    MenuItem [] items;
    int baseEtf;
    float surcharge;
    String paymentType;
    
    public float getCost()
    {
        float cost = 0.0f;
        
        for(MenuItem item : items)
            cost += item.getCost();
        
        cost += surcharge;
        
        return cost;
    }

    public Cafe getCafe()
    {
        return items[0].getCafe();

    }

    
    public int getEtf()
    {
        int etf = items.length;
        
        for(MenuItem item : items)
            etf += item.getEtf();
        
        etf += baseEtf;
        return etf;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    @Override
    public String toString(){
        String result = getCafe().getName();
        
        for(MenuItem item : items)
            result += item.getName() + ", " + item.getCost();
        
        return result;
    }
    
    @Override
    public int compareTo(Order o){
        int result = 0;
        
        if(this.getEtf() < o.getEtf())
            result--;
        
        else if(this.getEtf() > o.getEtf())
            result++;
        
        return result;
    }
}
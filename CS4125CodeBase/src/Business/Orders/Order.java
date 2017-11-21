package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public abstract class Order implements Comparable<Order>{
    
    MenuItem [] items;
    int baseEtf;
    float surcharge;
    String paymentType;
    /**
     * gets the cost of an item.
     */
    public float getCost()
    {
        float cost = 0.0f;
        
        for(MenuItem item : items)
            cost += item.getCost();
        
        cost += surcharge;
        
        return cost;
    }
    /**
     * returns the cafe name.
     */
    public Cafe getCafe()
    {
        return items[0].getCafe();

    }

    /**
     *  gets the estimated time to finish.
     */
    public int getEtf()
    {
        int etf = items.length;
        
        for(MenuItem item : items)
            etf += item.getEtf();
        
        etf += baseEtf;
        return etf;
    }
    /**
     * gets the payment type (not needed anymore?)
     */
    public String getPaymentType() {
        return paymentType;
    }
    /**
     * 
     */
    public abstract String getDetails();
    /**
     * checks to see which order will be done quicker.
     */
    @Override
    public int compareTo(Order o){
        int result = 0;
        
        if(this.getEtf() < o.getEtf())
            result--;
        
        else if(this.getEtf() > o.getEtf())
            result++;
        
        return result;
    }
    
    @Override
    public String toString(){
        return this.getDetails();
    }
}
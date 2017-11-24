package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public abstract class Order implements Comparable<Order>{
    
    MenuItem [] items;
    int baseEtf;
    float surcharge;
    String paymentType;
    /**
     * Gets the cost of an item.
     * @return cost Which is the price of the order.
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
     * Gets the Cafe menu.
     * @return items Which is Cafe menu.
     */
    public Cafe getCafe()
    {
        return items[0].getCafe();

    }

    /**
     *  Gets the estimated time to finish.
     * @return etf Estimated time to finish.
     */
    public int getEtf()
    {
        int etf = items.length;
        
        for(MenuItem item : items)
            etf += item.getEtf();
        
        etf += baseEtf;
        return etf;
    }
    
    public abstract String getDetails();
    
    /**
     * Checks to see which order will be done quicker.
     * @return result Which is what order is faster.
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
    
    /**
     * Converts Order to a String.
     * @return this.getDetails Which is a string.
     */
    @Override
    public String toString(){
        return this.getDetails();
    }
}
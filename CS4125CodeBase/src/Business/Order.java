package Business;

import Business.Profiles.Cafe;
import Data.MenuItem;

public class Order {
    
    MenuItem [] menuItems;
    
    public Order(MenuItem [] menuItems){
        this.menuItems = menuItems;
    }
    
    

    public float getCost()
    {
        float cost = 0.0f;
        
        for(MenuItem item : menuItems){
            cost += item.getCost();
        }
        
        return cost;
    }
    
    public Cafe getCafe()
    {
        return menuItems[0].getCafe();
    }
}
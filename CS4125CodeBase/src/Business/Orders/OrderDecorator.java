package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public class OrderDecorator extends Order{

    Order component;
    
    public OrderDecorator(Order component){
        this.component = component; 
    }

    @Override
    public float getCost()
    {
        return component.getCost();
    }

    @Override
    public Cafe getCafe()
    {
        return component.getCafe();
    }

    @Override
    public int getEtf()
    {
        return component.getEtf();
    }

    @Override
    public int compareTo(Order o)
    {
        return component.compareTo(o);
    }

}

package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public class OrderDecorator extends Order{

    Order component;
    /**
     *Constructor.
     * @param component which is a item in the current order.
     */
    public OrderDecorator(Order component){
        this.component = component; 
    }
    /**
     *Gets the components cost.
     * @return Components cost.
     */
    @Override
    public float getCost()
    {
        return component.getCost();
    }
    /**
     *Gets the components cafe.
     * @return Components cafe.
     */
    @Override
    public Cafe getCafe()
    {
        return component.getCafe();
    }
    /**
     *Gets the components estimated time to finish.
     * @return  Components estimated time to finish.
     */
    @Override
    public int getEtf()
    {
        return component.getEtf();
    }

    /**
     * Compares two orders to see which one is faster to make.
     * @param o Other order.
     * @return the result of which order is faster.
     */
    @Override
    public int compareTo(Order o)
    {
        return component.compareTo(o);
    }

    /**
     *Gets the details of the component
     * @return result of the components details.
     */
    @Override
    public String getDetails()
    {
        String result = getCafe().getName() + ", ";
        
        result += getCost();
        
        return result;}

}

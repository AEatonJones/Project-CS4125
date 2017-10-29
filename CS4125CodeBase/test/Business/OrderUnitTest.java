package Business;

import Business.Profiles.Cafe;
import Data.MenuItem;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class OrderUnitTest
{
    Cafe cafe;
    MenuItem[] items;
    Order order;
    
    @Before
    public void init()
    {
        try{
            cafe = new Cafe("Cafe great", "101 avenue", 10, "", "");

            items = new MenuItem[3];
            items[0] = new MenuItem(cafe, "coffee", 10.0f);
            items[1] = new MenuItem(cafe, "tea", 15.0f);
            items[2] = new MenuItem(cafe, "fruit", 20.0f);
            
            order = new Order(items);
            
        }catch(Exception e){
            fail("Should not have thrown an exception");
        }
    }
    
    @Test
    public void getCostTest(){
        assertEquals(10.0f + 15.0f + 20.0f, order.getCost(), 0.0f);
    }
    
    @Test
    public void getCafeTest(){
        assertEquals("Cafe great", order.getCafe().getName());
    }
    
}

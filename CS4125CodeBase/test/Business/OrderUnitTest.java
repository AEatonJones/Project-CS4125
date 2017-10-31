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
    Order order1;
    Order order2;
    
    @Before
    public void init()
    {
        try{
            cafe = new Cafe("Cafe great", "101 avenue", 10, "", "");

            items = new MenuItem[3];
            items[0] = new MenuItem(cafe, "coffee", 10.0f);
            items[1] = new MenuItem(cafe, "tea", 15.0f);
            items[2] = new MenuItem(cafe, "fruit", 20.0f);
            
            String paymentType = "CC";
            
            order1 = new Order(items,paymentType);
            order2 = new Order(items,paymentType);
            
        }catch(Exception e){
            fail("Should not have thrown an exception");
            e.printStackTrace();
        }
    }
    
    @Test
    public void getCostTest(){
        assertEquals(10.0f + 15.0f + 20.0f, order1.getCost(), 0.0f);
    }
    
    @Test
    public void getCafeTest(){
        assertEquals("Cafe great", order1.getCafe().getName());
    }
    
    @Test
    public void compareToTest(){
        assertEquals(0, order1.compareTo(order2));
    }
    
}

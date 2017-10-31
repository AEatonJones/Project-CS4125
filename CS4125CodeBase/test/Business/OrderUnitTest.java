package Business;

import Business.Orders.LargeOrder;
import Business.Orders.Order;
import Business.Orders.MediumOrder;
import Business.Orders.SmallOrder;
import Business.Orders.ToGo;
import Business.Profiles.Cafe;
import Data.MenuItem;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class OrderUnitTest
{
    Cafe cafe;
    MenuItem[] items;
    Order orderToGo;
    Order orderToStay;
    
    @Before
    public void init() {
        try{
            cafe = new Cafe("Cafe great", "101 avenue", 10, "", "");

            items = new MenuItem[3];
            items[0] = new MenuItem(cafe, "coffee", 10.0f, 2);
            items[1] = new MenuItem(cafe, "tea", 15.0f, 1);
            items[2] = new MenuItem(cafe, "fruit", 20.0f, 0);
            
            orderToGo  = new ToGo(items);
            
            
        }catch(Exception e){
            fail("Should not have thrown an exception");
        }
    }
    
    @Test
    public void getCostTest(){
        assertEquals(10.0f + 15.0f + 20.0f + 1.0f, orderToGo.getCost(), 0.0f);
    }
    
    @Test
    public void getCafeTest(){
        assertEquals("Cafe great", orderToGo.getCafe().getName());
    }
    
    @Test
    public void getEtfTest(){
        assertEquals(3 + items.length + 1, orderToGo.getEtf());
    }
    
    @Test
    public void compareToTest(){
        assertEquals(0, orderToGo.compareTo(orderToGo));
    }
    
}

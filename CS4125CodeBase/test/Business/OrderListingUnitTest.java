package Business;

import Data.MenuItem;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OrderListingUnitTest{
    
    OrderListing listing;
    Order order;
    MenuItem[] items;
    MenuItem item;
    
    @Before
    public void init(){
        item = new MenuItem(null, "Water", 5.0f);
        items = new MenuItem[]{item};
        order = new Order(items);
        listing = new OrderListing();
    }
    
    @Test
    public void pushAndPopTest(){
        assertEquals(0, listing.getLength());
        
        listing.push(order);
        assertEquals(1, listing.getLength());
        
        assertEquals(order, listing.grab(0));
        assertEquals(0, listing.getLength());
    }
    
}

package Business;

import Business.Orders.Order;
import Business.Orders.ToGo;
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
        item = new MenuItem(null, "Water", 5.0f,1);
        items = new MenuItem[]{item};
        String paymentType = "COA";
        order = new ToGo(items,paymentType);
        listing = new OrderListing();
    }
    
    @Test
    public void pushAndPickTest(){
        assertEquals(0, listing.amountWaiting());
        
        listing.push(order);
        assertEquals(1, listing.amountWaiting());
        
        listing.pick(order);
        assertEquals(0, listing.amountWaiting());
        assertEquals(1, listing.amountReady());
    }
    
}

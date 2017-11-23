package Data;

import Business.Orders.SmallOrder;
import Business.Orders.ToGo;
import Business.Profiles.Cafe;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OrderDBUnittest
{
    Cafe cafe;
    MenuItem[] items;
    
    @Before
    public void init() throws IOException{
        cafe = new Cafe("Cafe great", "101 avenue", 10, "", "",1000.00);

        items = new MenuItem[3];
        items[0] = new MenuItem(cafe, "coffee", 10.0f, 2);
        items[1] = new MenuItem(cafe, "tea", 15.0f, 1);
        items[2] = new MenuItem(cafe, "fruit", 20.0f, 0);
    }
    
    
    @Test
    public void addOrderTest(){
        try{
            OrderDB.getInstance().addOrder(new SmallOrder(new ToGo(items, "CC")));
        }catch(Exception e){
            e.printStackTrace();
            fail("Should not have thrown an exception");
        }
    }
}

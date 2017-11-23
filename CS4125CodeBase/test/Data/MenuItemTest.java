package Data;

import Business.Profiles.Cafe;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MenuItemTest {

    Cafe cafe;
    MenuItem item;
    
    @Before
    public void init()
    {
        try{
            cafe = new Cafe("Cafe great", "101 avenue", 10, "", "",1000.00);
            item = new MenuItem(cafe, "Scone",10.0f, 4);
        }catch(Exception e){
            fail("Should not throw an Exception");
        }
    }
    
    @Test
    public void getCostTest() {
        assertEquals("Cafe great", item.getCafe().getName());
    } 
    
    @Test
    public void getCafeTest(){
        assertEquals("Cafe great", item.getCafe().getName());
    }
    
    @Test
    public void getETFTest(){
        assertEquals(4, item.getEtf());
    }
}

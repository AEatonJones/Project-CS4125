package Data;

import Business.Profiles.Cafe;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuItemTest {

    
    @Test
    public void testGetCost() {
        Cafe cafe;
        try
        {
            cafe = new Cafe("Cafe great", "101 avenue", 10, "", "");
            MenuItem item = new MenuItem(cafe, "Scone",10.0f);
            assertEquals(10.0f, item.getCost(), 0.0f);
        } 
        catch (IOException ex)
        {
            fail("Should not have thrown IOException");
        }
    }   
}

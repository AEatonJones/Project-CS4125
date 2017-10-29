package Data;

import Business.Profiles.Cafe;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuItemTest {

    private float cost;
    String name;
    Cafe cafe;
    
    public MenuItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public void testGetCost() {
        MenuItem item = new MenuItem(cafe,name,10.0f);
        System.out.println("getCost");       
        float expResult = 10.0f;
        float result = item.getCost();
        assertEquals(expResult, result, 10.0f);        
        //fail("The test case is a prototype.");
    }   
}

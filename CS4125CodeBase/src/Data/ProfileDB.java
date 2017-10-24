package Data;

import Business.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;

public class ProfileDB {
    
    private static ProfileDB instance = null;
    
    public static ProfileDB getInstance()
    {
        if(instance == null)
            instance = new ProfileDB();
        
        return instance;
    }
    
    public ArrayList<Order> getMenuFromCafe(Cafe cafe)
    {
        ArrayList<Order> result = new ArrayList<Order>();
        
        
        
        return result;
    }
    
}

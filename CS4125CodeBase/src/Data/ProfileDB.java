package Data;

import Business.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;
import java.io.*;

public class ProfileDB {
    
    private static ProfileDB instance = null;
    
    public static ProfileDB getInstance()
    {
        if(instance == null)
            instance = new ProfileDB();
        
        return instance;
    }
    
    public ArrayList<Order> getMenuFromCafe(Cafe cafe) throws IOException
    {
        ArrayList<Order> result = new ArrayList<Order>();
        
        BufferedReader reader = new BufferedReader(new FileReader(".\\resources\\Profiles\\Cafe\\Menus.txt"));
        String line;
        boolean found = false;
        while(((line = reader.readLine()) != null) && !found) 
        {
            if(line.equals(cafe.getName() + ":"))
            {
                found = true;
                while(!(line = reader.readLine()).equals("end."))
                {
                    String [] orderDetails = line.split(",");
                    String name = orderDetails[0];
                    Float cost = Float.parseFloat(orderDetails[1]);
                    result.add(new Order(cafe, name, cost));
                }
            }
        }
        
        return result;
    }
  
}

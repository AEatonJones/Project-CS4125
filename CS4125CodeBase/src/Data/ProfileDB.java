package Data;

import Business.Orders.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;
import java.io.*;

public class ProfileDB {
    
    private static ProfileDB instance = null;
    
    private ProfileDB(){
        
    }
    
    public static ProfileDB getInstance(){
        if(instance == null)
            instance = new ProfileDB();
        
        return instance;
    }
    
    public Cafe getCafeByDetails(String name, String address) throws IOException
    {
        Cafe result = null;
        String filepath = ".\\src\\Resources\\Profiles\\Cafe\\Cafes.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        boolean found = false;
        while(((line = reader.readLine()) != null) && !found) 
        {
            String [] cafeDetails = line.split(",");
            if(cafeDetails[0].equals(name))
            {
                if(cafeDetails[1].equals(address))
                {
                    found = true;
                    String cafeName = cafeDetails[0];
                    String cafeAddress = cafeDetails[1];
                    int employeeCount = Integer.parseInt(cafeDetails[2]);
                    String email = cafeDetails[3];
                    String number = cafeDetails[4];
                    result = new Cafe(cafeName, cafeAddress, employeeCount, email, number);
                }
            }
        }
        
        return result;
    }
    
    public ArrayList<MenuItem> getMenuFromCafe(Cafe cafe) throws IOException
    {
        ArrayList<MenuItem> result = new ArrayList<MenuItem>();
        String filepath = ".\\src\\Resources\\Profiles\\Cafe\\Menus.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
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
                    result.add(new MenuItem(cafe, name, cost, 1));
                }
            }
        }
        
        return result;
    }
  
}

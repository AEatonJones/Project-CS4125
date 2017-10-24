package Business.Profiles;

import Data.Menu;

public class Cafe extends Profile {

    private String name;
    private String address;
    private Menu cafeMenu;
    private int numberOfEmployees;
    
    public Cafe(String email, String number, String type) {
        super(email,number);
        
    }
    
    public String getName()
    {
        return name;
    }
       
}

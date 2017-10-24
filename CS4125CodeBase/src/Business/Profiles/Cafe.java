package Business.Profiles;

import Data.Menu;

public class Cafe extends Profile {

    private String name;
    private String address;
    private int numberOfEmployees;
    private Menu cafeMenu;
    
    public Cafe(String email, String number) {
        super(email,number);
        
    }
    
    public String getName()
    {
        return name;
    }
       
    public Menu getMenu()
    {
        return cafeMenu;
    }
}

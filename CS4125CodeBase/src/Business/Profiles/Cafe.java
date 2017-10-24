package Business.Profiles;

import Data.Menu;
import Data.ProfileDB;
import java.io.IOException;

public class Cafe extends Profile {

    private String name;
    private String address;
    private int employeeCount;
    private Menu cafeMenu;
    
    public Cafe(String email, String number, String name, String address, int employeeCount) throws IOException {
        super(email,number);
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
        this.cafeMenu = new Menu(this,ProfileDB.getInstance().getMenuFromCafe(this));
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

package Business.Profiles;

import Data.Menu;
import Data.ProfileDB;
import java.io.IOException;

public class Cafe extends Profile {

    private String name;
    private String address;
    private int employeeCount;
    private Menu cafeMenu;
    private double balance;
    
    public Cafe(String name, String address, int employeeCount, String email, String number) throws IOException {
        super(email,number);
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
        this.cafeMenu = new Menu(this,ProfileDB.getInstance().getMenuFromCafe(this));
        this.balance = 0;
    }
    
    public String getName() {
        return name;
    }
       
    public Menu getMenu() {
        return cafeMenu;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double cost) {
        
    }
}

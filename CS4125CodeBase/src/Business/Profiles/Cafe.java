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
    
    /**
     *Constructor.
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     * @param employeeCount The amount of employees that work there.
     * @param email The email of the cafe.
     * @param number The number of the cafe.
     */
    public Cafe(String name, String address, int employeeCount, String email, String number) throws IOException {
        super(email,number);
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
        this.cafeMenu = new Menu(this,ProfileDB.getInstance().getMenuFromCafe(this));
        this.balance = 0;
    }
    
    /**
     *Gets the name of the cafe.
     * @return Name of the cafe.
     */
    public String getName() {
        return name;
    }
    
    /**
     *Gets the address of the cafe.
     * @return Address of the cafe.
     */
    public String getAddress() {
        return address;
    }
       
    /**
     *Gets the menu of the cafe.
     * @return Menu of the cafe.
     */
    public Menu getMenu() {
        return cafeMenu;
    }
    
    /**
     *Gets the balance of the cafe.
     * @return Balance of the cafe.
     */
    public double getBalance() {
        return balance;
    }
    /**
     *Sets the balance (not used?).
     * @[aram cost
     */
    public void setBalance(double cost) {
        
    }
    /**
     *Converts to a string.
     * @return name (should it be name?).
     */
    @Override
    public String toString(){
        return name;
    }
}

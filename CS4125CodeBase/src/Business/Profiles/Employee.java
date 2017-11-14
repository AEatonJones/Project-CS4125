package Business.Profiles;

import Data.OrderDB;
import Business.Information_Managers.ProfileControl;

public class Employee extends Customer {
    
    private int id;
    private Cafe cafe;

    public Employee(String firstname, String surname, String email, String password, String number, Cafe cafe) {
        super(firstname,surname,email,password,number);
        this.cafe = cafe;
        this.id = ProfileControl.assignID(cafe);
    }
    
    public Cafe getCafe() {
        return cafe;
    }
    
    public int getID() {
        return id;
    }
}

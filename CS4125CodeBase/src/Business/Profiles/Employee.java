package Business.Profiles;

import Data.OrderDB;
import Business.Information_Managers.ProfileControl;

public class Employee extends Customer {
    
    private String id;
    private Cafe cafe;

    public Employee(String firstname, String surname, String email, String password, String number, String type,Cafe cafe) {
        super(firstname,surname,email,password,number,type);
        this.cafe = cafe;
        this.id = ProfileControl.assignID(cafe);


    }
}

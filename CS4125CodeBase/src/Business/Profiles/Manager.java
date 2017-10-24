package Business.Profiles;
import Data.ProfileDB;

public class Manager extends Employee {
    
        public Manager(String firstname, String surname, String email, String password, String number, Cafe cafe) {
            super(firstname,surname,email,password,number,cafe);
    }
}

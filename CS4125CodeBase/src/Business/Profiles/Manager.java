package Business.Profiles;
import Data.ProfileDB;

public class Manager extends Employee {
    
        public Manager(String firstname, String surname, String email, String password, String number, String type, Cafe cafe) {
            super(firstname,surname,email,password,number,type,cafe);
    }
}

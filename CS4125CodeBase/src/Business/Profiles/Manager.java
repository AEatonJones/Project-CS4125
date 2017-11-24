package Business.Profiles;
import Data.ProfileDB;

public class Manager extends Employee {
    
    /**
     * Constructor.
     * @param firstname First name of manager.
     * @param surname Surname of manager.
     * @param email Manager account email.
     * @param password Manager account password.
     * @param number Manager phone number.
     * @param cafe Each manager holds their cafe object.
     */
        public Manager(String firstname, String surname, String email, String password, String number, Cafe cafe) {
            super(firstname,surname,email,password,number,cafe);
    }
}

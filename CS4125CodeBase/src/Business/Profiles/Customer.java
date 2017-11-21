package Business.Profiles;

public class Customer extends Profile {
    
    private String firstname, surname, password;
    
    public Customer(String firstname, String surname, String email, String password,String number) {
       super(email, number);
       this.firstname = firstname;
       this.surname = surname;
       this.password = password;
       
    }
    /**
     * getter which gets the customers first name.
     */
    public String getFirstName() {
        return this.firstname;
    }
    /**
     * getter which gets the customers sur name.
     */
    public String getSurname() {
        return this.surname;
    }
    /**
     * getter which gets the customers password.
     */
    public String getPassword() {
        return this.password;
    }
            
}
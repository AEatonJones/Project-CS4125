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
     * Getter which gets the customers first name.
     * @return First name of customer.
     */
    public String getFirstName() {
        return this.firstname;
    }
    /**
     * Getter which gets the customers sur name.
     * @return Sur name of customer.
     */
    public String getSurname() {
        return this.surname;
    }
    /**
     * Getter which gets the customers password.
     * @return Password of customer.
     */
    public String getPassword() {
        return this.password;
    }
            
}
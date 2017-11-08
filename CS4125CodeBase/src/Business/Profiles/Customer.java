package Business.Profiles;

public class Customer extends Profile {
    
    private String firstname, surname, password;
    
    public Customer(String firstname, String surname, String email, String password,String number) {
       super(email, number);
       this.firstname = firstname;
       this.surname = surname;
       this.password = password;
       
    }
    
    public String getFirstName() {
        return this.firstname;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getPassword() {
        return this.password;
    }
            
}
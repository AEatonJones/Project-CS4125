package Business.Profiles;

public class Customer extends Profile {
    
    private String firstname, surname, password;
    
    public Customer(String firstname, String surname, String email, String password,String number,String type) {
       super(email, number, type);
       this.firstname = firstname;
       this.surname = surname;
       this.password = password;
       
    }
}
package Business.Profiles;

public class ProfileFactory 
{
    public static Profile createProfile(String type){
        Profile profile = null;
        switch(type){
            case "Customer":profile = createCustomer();break;
            case "Employee":profile = createEmployee();break;
            case "Manager": profile = createManager();break;
            case "Cafe":    profile = createCafe();break;
            default:break;
        }
        
        return profile;
    }
    
    private static Profile createCustomer(){
        Profile profile = null;
        //public Customer(String firstname, String surname, String email, String password,String number,String type)
        String firstname = null, surname = null, email = null, password = null, number = null;
        
        profile = new Customer(firstname, surname, email, password, number);
        
        return profile;
    }
    
    private static Profile createEmployee(){
        Profile profile = null;
        
        return profile;
    }
    
    private static Profile createManager(){
        Profile profile = null;
        
        return profile;
    }
    
    private static Profile createCafe(){
        Profile profile = null;
        
        return profile;
    }
    
}

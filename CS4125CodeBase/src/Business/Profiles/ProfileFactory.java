package Business.Profiles;

public class ProfileFactory 
{
    public static Profile createProfile(String number, String email, String type){
        Profile profile = null;
        switch(type){
            case "Customer":profile = createCustomer(number, email);break;
            case "Employee":profile = createEmployee(number, email);break;
            case "Manager": profile = createManager(number, email);break;
            case "Cafe":    profile = createCafe(number, email);break;
            default:break;
        }
        
        return profile;
    }
    
    private static Profile createCustomer(String number, String email){
        Profile profile = null;
        
        return profile;
    }
    
    private static Profile createEmployee(String number, String email){
        Profile profile = null;
        
        return profile;
    }
    
    private static Profile createManager(String number, String email){
        Profile profile = null;
        
        return profile;
    }
    
    private static Profile createCafe(String number, String email){
        Profile profile = null;
        
        return profile;
    }
    
}

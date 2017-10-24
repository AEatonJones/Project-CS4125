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
        
        String [] customerDetails = (JOptionPane).split(",");//Use JOPtion pane with comma seperated values to get customerdetails
        
        firstname = customerDetails[0];
        
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

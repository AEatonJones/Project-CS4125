package Business.Profiles;

import java.io.IOException;

public class ProfileFactory 
{
    public static Profile createProfile(String type) throws IOException{
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
    
    //public Customer(String firstname, String surname, String email, String password,String number,String type)
    private static Profile createCustomer(){
        Profile profile = null;
        
        String firstname = null, surname = null, email = null, password = null, number = null;

        //Prompt to add info via UI
        
        profile = new Customer(firstname, surname, email, password, number);
        return profile;
    }
    
    //public Employee(String firstname, String surname, String email, String password, String number, Cafe cafe)
    private static Profile createEmployee(){
        Profile profile = null;
        
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = null;
        
        //Prompt to add info via UI
        
        profile = new Employee(firstname, surname, email, password, number,cafe);
        return profile;
    }
    
    //public Manager(String firstname, String surname, String email, String password, String number, Cafe cafe)
    private static Profile createManager(){
        Profile profile = null;
        
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = null;
        
        //Prompt to add info via UI
        
        profile = new Employee(firstname, surname, email, password, number,cafe);
        return profile;
    }
    
    //public Cafe(String name, String address, int employeeCount, String email, String number)
    private static Profile createCafe() throws IOException{
        Profile profile = null;
        
        String name = null, address = null, email = null, number = null;
        int employeeCount = 0; 
        
        //Prompt to add info via UI
        
        profile = new Cafe(name,address,employeeCount,email,number);
        return profile;
    }
    
}

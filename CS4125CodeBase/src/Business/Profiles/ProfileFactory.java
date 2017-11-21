package Business.Profiles;

import Data.ProfileDB;
import UI.CustomerUI;
import java.io.IOException;

public class ProfileFactory 
{
    
    public static Profile createProfile(String type,String[] array) throws IOException {
        Profile profile = null;
        switch(type){
            case "Customer":profile = createCustomer(array);break;
            case "Employee":profile = createEmployee(array);break;
            case "Manager": profile = createManager(array);break;
            default:break;
        }
        
        return profile;
    }
    
    //public Customer(String firstname, String surname, String email, String password,String number,String type)
    private static Profile createCustomer(String[] array) {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        String [] customerDetails = new String[5];      
        profile = new Customer(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4]);
        return profile;
    }
    
    //public Employee(String firstname, String surname, String email, String password, String number, Cafe cafe)
    private static Profile createEmployee(String[] array) throws IOException {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = ProfileDB.getInstance().getCafeByDetails(array[5], array[6]); 
        profile = new Employee(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4],cafe);      
        return profile;
    }
    
    //public Manager(String firstname, String surname, String email, String password, String number, Cafe cafe)
    private static Profile createManager(String[] array) throws IOException {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = ProfileDB.getInstance().getCafeByDetails(array[5], array[6]);  
        profile = new Manager(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4],cafe);      
        return profile;
    }   
}
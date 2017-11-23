package Business.Profiles;

import Data.ProfileDB;
import UI.CustomerUI;
import java.io.IOException;

public class ProfileFactory 
{
    /**
     * Creates a profile of a certain type.
     *@param type Used to determine which type of profile will be created.
     * @param array Holds the information of the profile to be created.
     * @return profile Which is either of customer, employee or manager type.
     * @throws IOException Throws IO Exception.
     */
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
    
    /**
     * Creates a profile of customer type.
     * @return profile Which is of customer type.
     */
    private static Profile createCustomer(String[] array) {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        String [] customerDetails = new String[5];      
        profile = new Customer(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4]);
        return profile;
    }
    
    /**
     * Creates a profile of employee type.
     * @return profile Which is of employee type.
     */
    private static Profile createEmployee(String[] array) throws IOException {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = ProfileDB.getInstance().getCafeByDetails(array[5], array[6]); 
        profile = new Employee(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4],cafe);      
        return profile;
    }
    
    /**
     *Creates a profile of manager type.
     * @return profile Which is of manager type.
     */
    private static Profile createManager(String[] array) throws IOException {
        Profile profile = null;
        String firstname = null, surname = null, email = null, password = null, number = null;
        Cafe cafe = ProfileDB.getInstance().getCafeByDetails(array[5], array[6]);  
        profile = new Manager(firstname = array[0], surname = array[1], email = array[2], password = array[3], number = array[4],cafe);      
        return profile;
    }   
}
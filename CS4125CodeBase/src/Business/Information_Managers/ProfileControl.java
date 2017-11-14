package Business.Information_Managers;
import Business.Profiles.Cafe;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileControl {
   /*
    private static ProfileControl instance = null;
    
    private ProfileControl(){
        
    }
    
    
    public static ProfileControl getInstance(){
        if(instance == null)
            instance = new ProfileControl();
        
        return instance;
    }
    */
   
    public static int assignID(Cafe cafe) {
        int id = 0;
        
         
        return id;
    }
    
    public static Profile verifyProfile(String email,String password) throws IOException {
        Profile result = null;
        String filepath = ".\\src\\Resources\\Profiles\\Customers.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        boolean found = false;
        while(((line = reader.readLine()) != null) && !found) 
        {
            String [] customerDetails = line.split(",");
            if(customerDetails[2].equalsIgnoreCase(email))
            {
                if(customerDetails[3].equalsIgnoreCase(password))
                {
                    found = true;
                    result = ProfileFactory.createProfile("Customer",customerDetails);
                }
            }
        }
        
        return result;
    }
    //cunt
    
    public static void printToFile(String[] profile) throws IOException {
        String filepath = ".\\src\\Resources\\Profiles\\Customers.txt";
        FileWriter fr = new FileWriter(filepath,true);
        try {
            for(int i = 0 ; i < profile.length; i++) {
                    fr.append(profile[i] + ",");
            }
        fr.append("\n");
        }catch(IOException e) {
            e.printStackTrace();
        }
        fr.close();
    }
    
    public static ArrayList<String> obtainEmployeeInfo(String cafe) throws IOException {
        ArrayList<String> Employee = new ArrayList<String>();
        String filepath = ".\\src\\Resources\\Profiles\\Managers.txt";
        String details = null;
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        Employee.add("Managers");
        while((line = reader.readLine()) != null) 
        {
            String [] managerDetails = line.split(",");
            if(managerDetails[5].equalsIgnoreCase(cafe)) {
                details = managerDetails[0] + " "+managerDetails[1] + " "+managerDetails[2] + " " + managerDetails[4];
                Employee.add(details);
            }
        }
        
        filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
        reader = new BufferedReader(new FileReader(filepath));
        Employee.add("Employees");
        while((line = reader.readLine()) != null) 
        {
            String [] EmployeeDetails = line.split(",");
            if(EmployeeDetails[5].equalsIgnoreCase(cafe)) {
                details = EmployeeDetails[0]+" "+EmployeeDetails[1]+" "+EmployeeDetails[2]+" "+EmployeeDetails[4];
                Employee.add(details);
            }
        }
        return Employee;
    }
}
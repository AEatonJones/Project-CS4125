package Business.Information_Managers;
import Business.Profiles.Cafe;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import Data.ProfileDB;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author hmaug
 */
public class ProfileControl {
   
    /**
     *
     * @param cafe Cafe object.
     * @return
     */
    public static int assignID(Cafe cafe) {
        int id = 0;
        return id;
    }
    
    /**
     * Verifies if users login exists and get there information if they do.
     * @param email Email of the profile which is logging in.
     * @param password Password for the profile which is logging in.
     * @param type Type of the profile which is logging in.
     * @return result if profile is there.
     * @throws IOException
     */
    public static Profile verifyProfile(String email,String password,int type) throws IOException {
        Profile result = null;
        String filepath;
        BufferedReader reader;
        String line;
        boolean found = false;
        if (type == 1) { // type = customer
            filepath = ".\\src\\Resources\\Profiles\\Customers.txt";
            reader = new BufferedReader(new FileReader(filepath));
            while(((line = reader.readLine()) != null) && !found) {
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
        }
        else if (type == 2) { // type = employee
            filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
            reader = new BufferedReader(new FileReader(filepath));
            while(((line = reader.readLine()) != null) && !found) {
                String [] employeeDetails = line.split(",");
                if(employeeDetails[2].equalsIgnoreCase(email))
                {
                    if(employeeDetails[3].equalsIgnoreCase(password))
                    {
                        found = true;
                        result = ProfileFactory.createProfile("Employee",employeeDetails);
                    }
                }
            }
        }
        else if (type == 3) { // type = manager
            filepath = ".\\src\\Resources\\Profiles\\Managers.txt";
            reader = new BufferedReader(new FileReader(filepath));
            while(((line = reader.readLine()) != null) && !found) {
                String [] managerDetails = line.split(",");
                if(managerDetails[2].equalsIgnoreCase(email) && managerDetails[3].equalsIgnoreCase(password))
                {
                    found = true;
                    result = ProfileFactory.createProfile("Manager",managerDetails);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Removes selected employee from file if being promoted.
     * @param info Information on the profile.
     * @throws IOException
     */
    public static void removeFromFile(String info) throws IOException {
        String line;
        File file = new File(".\\src\\Resources\\Profiles\\Employees.txt");
        File tempFile = new File(file + ".tmp");
        //String filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
        String finalFileContents = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while(((line = reader.readLine()) != null)) {
            if(!(line.equals(info))) {
                finalFileContents += line + "\n";
            }
        }
        reader.close();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(finalFileContents);
        
        writer.close();
    }
    
    /**
     * Writes the info of employee which was promoted too a new file.
     * @param profile All the information of the profile.
     * @param type The type of the profile.
     * @throws IOException
     */
    public static void printToFile(String[] profile,int type) throws IOException {
        String filepath;
        FileWriter fr;
        if(type == 1) { // type = customer
            filepath = ".\\src\\Resources\\Profiles\\Customers.txt";
            fr = new FileWriter(filepath,true);
            try {
                fr.append("\n");
                for(int i = 0 ; i < profile.length; i++) {
                        fr.append(profile[i] + ",");
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
            fr.close();
        }
        else if(type == 2) { // type = employee
            filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
            fr = new FileWriter(filepath,true);
            try {
                fr.append("\n");
                for(int i = 0 ; i < profile.length; i++) {
                        fr.append(profile[i] + ",");
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
            fr.close();
        }
        else if(type == 3) { // type = manager
            filepath = ".\\src\\Resources\\Profiles\\Managers.txt";
            fr = new FileWriter(filepath,true);
            try {
                fr.append("\n");
                for(int i = 0 ; i < profile.length; i++) {
                        fr.append(profile[i] + ",");
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
            fr.close();
        }
    }
    
    /**
     * Adds new Manager info to file and returns that info.
     * @param cafe Cafe object.
     * @return Employee
     * @throws IOException
     */
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
    
   
    /**
     *Check if details match that of a manager.
     * @param details Details of the profile.
     * @return result if profile is manager.
     * @throws IOException
     */
    public static boolean checkIfManager(String details) throws IOException {
        boolean result = false;
        String filepath = ".\\src\\Resources\\Profiles\\Managers.txt";
        String line;
        String[] empDetails = details.split(" ");
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        while(((line = reader.readLine()) != null) && !result) {
            String[] info = line.split(",");
            if((empDetails[0].equals(info[0])) && (empDetails[1].equals(info[1])) && (empDetails[2].equals(info[2])) && (empDetails[3].equals(info[4])))
                result = true;
        }
        return result;
    }
    
    /**
     * Finds employee details and promotes to manager by calling removeFromFile and printToFile.
     * @param details Details of the profile.
     * @throws IOException
     */
    public static void promoteToManager(String details) throws IOException {
        boolean found = false;
        String filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
        String line;
        String[] empDetails = details.split(" ");
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        while(((line = reader.readLine()) != null) && !found) {
            String[] info = line.split(",");
            if((empDetails[0].equals(info[0])) && (empDetails[1].equals(info[1])) && (empDetails[2].equals(info[2])) && (empDetails[3].equals(info[4]))) {
                found = true;
                removeFromFile(line);
                printToFile(info,3);
            }
        }
    }
}
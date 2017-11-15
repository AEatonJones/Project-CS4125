package Business.Information_Managers;
import Business.Profiles.Cafe;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import Data.ProfileDB;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileControl {
   
    public static int assignID(Cafe cafe) {
        int id = 0;
        return id;
    }
    
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
                if(managerDetails[2].equalsIgnoreCase(email))
                {
                    if(managerDetails[3].equalsIgnoreCase(password))
                    {
                        found = true;
                        result = ProfileFactory.createProfile("Manager",managerDetails);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void printToFile(String[] profile,int type) throws IOException {
        String filepath;
        FileWriter fr;
        Cafe cafe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        if(type == 1) { // type = customer
            filepath = ".\\src\\Resources\\Profiles\\Customers.txt";
            fr = new FileWriter(filepath,true);
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
        else if(type == 2) { // type = employee
            filepath = ".\\src\\Resources\\Profiles\\Employees.txt";
            fr = new FileWriter(filepath,true);
            try {
                for(int i = 0 ; i < profile.length; i++) {
                        fr.append(profile[i] + ",");
                }
            fr.append(cafe.getName() + ",");
            fr.append("\n");
            }catch(IOException e) {
                e.printStackTrace();
            }
            fr.close();
        }
        else if(type == 3) { // type = manager
            filepath = ".\\src\\Resources\\Profiles\\Managers.txt";
            fr = new FileWriter(filepath,true);
            try {
                for(int i = 0 ; i < profile.length; i++) {
                        fr.append(profile[i] + ",");
                }
            fr.append(cafe.getName() + ",");
            fr.append("\n");
            }catch(IOException e) {
                e.printStackTrace();
            }
            fr.close();
        }
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
    
    public static String[] obtainCafeInfo(String cafe) throws IOException {
        String[] cafeInfo = new String[5];
        String filepath = ".\\src\\Resources\\Profiles\\Cafe\\Cafes.txt";
        String details = null;
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        while((line = reader.readLine()) != null) 
        {
            String [] managerDetails = line.split(",");
            if(managerDetails[5].equalsIgnoreCase(cafe)) {
                details = managerDetails[0] + " "+managerDetails[1] + " "+managerDetails[2] + " " + managerDetails[4];
            }
        }
        return cafeInfo;
    }
}
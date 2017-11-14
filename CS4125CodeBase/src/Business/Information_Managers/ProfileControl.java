package Business.Information_Managers;
import Business.Profiles.Cafe;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
}

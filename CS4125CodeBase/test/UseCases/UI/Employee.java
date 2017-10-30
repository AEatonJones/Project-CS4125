package UseCases.UI;

import Business.Profiles.Cafe;
import Data.OrderDB;
import Data.ProfileDB;
import UI.CustomerUI;
import UI.EmployeeUI;
import java.io.IOException;

public class Employee 
{
    public static void main(String [] args) throws IOException{
        EmployeeUI eUI = new EmployeeUI();
        OrderDB.getInstance().attachObserver(eUI);
        
        Cafe waffe = ProfileDB.getInstance().getCafeByDetails("Cafe Waffe", "110 Main Street");
        CustomerUI cUI = new CustomerUI(waffe);
        
        cUI.draw();
        eUI.draw();
    }
}

package UseCases.useCase1;

import Business.Profiles.Cafe;
import Data.ProfileDB;
import UI.CustomerUI;
import java.io.IOException;

public class useCase1 
{
    public static void main(String [] args) throws IOException
    {
        Cafe waffe = ProfileDB.getInstance().getCafeByDetails("Cafe Waffe", "110 Main Street");
        System.out.println(waffe == null);
        new CustomerUI(waffe);
    }
}

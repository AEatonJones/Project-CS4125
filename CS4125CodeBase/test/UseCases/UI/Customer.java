package UseCases.UI;

import Business.Profiles.Cafe;
import Data.ProfileDB;
import UI.CustomerUI;
import java.io.IOException;

public class Customer 
{
    public static void main(String [] args) throws IOException
    {
        new CustomerUI().draw();
    }
}

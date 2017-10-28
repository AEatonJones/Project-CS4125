package Data;

import Business.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;

public class Menu {
    Cafe cafe;
    ArrayList<MenuItem> choices;
    
    public Menu(Cafe cafe, ArrayList<MenuItem> choices)
    {
        this.cafe = cafe;
        this.choices = choices;
    }
    
    public ArrayList<MenuItem> getChoices()
    {
        return choices;
    }
}

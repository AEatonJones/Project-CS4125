package Data;

import Business.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;

public class Menu {
    Cafe cafe;
    ArrayList<Order> choices;
    
    public Menu(Cafe cafe, ArrayList<Order> choices)
    {
        this.cafe = cafe;
        this.choices = choices;
    }
}

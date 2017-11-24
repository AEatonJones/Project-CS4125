package Data;

import Business.Orders.Order;
import Business.Profiles.Cafe;
import java.util.ArrayList;

public class Menu {
    Cafe cafe;
    ArrayList<MenuItem> choices;
    
    /**
     *Constructor.
     * @param cafe Cafe object.
     * @param choices which is an ArrayList of chosen items.
     */
    public Menu(Cafe cafe, ArrayList<MenuItem> choices)
    {
        this.cafe = cafe;
        this.choices = choices;
    }
    /**
     *Gets the chosen items.
     * @return The choices of the customer.
     */
    public ArrayList<MenuItem> getChoices()
    {
        return choices;
    }
}

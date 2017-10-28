package Data;

import Business.Profiles.Cafe;

public class MenuItem 
{
    Cafe cafe;
    String name;
    private float cost;
    
    public MenuItem(Cafe cafe, String name, float cost){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
    }
    
    public float getCost(){
        return this.cost;
    }
}

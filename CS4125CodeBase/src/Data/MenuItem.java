package Data;

import Business.Profiles.Cafe;

public class MenuItem 
{
    private Cafe cafe;
    private String name;
    private float cost;
    
    public MenuItem(Cafe cafe, String name, float cost){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
    }
    
    public float getCost(){
        return this.cost;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Cafe getCafe(){
        return this.cafe;
    }
}

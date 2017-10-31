package Data;

import Business.Profiles.Cafe;

public class MenuItem 
{
    private Cafe cafe;
    private String name;
    private float cost;
    private int etf;
    
    public MenuItem(Cafe cafe, String name, float cost, int etf){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
        this.etf = etf;
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

    public int getEtf()
    {
        return this.etf;
    }
}

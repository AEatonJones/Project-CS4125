package Business;

import Business.Profiles.Cafe;

public class Order {
    
    private Cafe cafe;
    private String name;
    private float cost;
    
    public Order(Cafe cafe, String name, float cost){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
    }
    
    @Override
    public String toString(){
        String string = cafe.getName() + "," + name + " = " + cost;
        return string;
    }

    public float getCost()
    {
        return cost;
    }
    
}
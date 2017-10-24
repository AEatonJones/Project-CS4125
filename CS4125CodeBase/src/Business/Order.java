package Business;

import Business.Profiles.Cafe;

public class Order {
    
    private Cafe cafe;
    private String name;
    private float cost;
    
    public Order(Cafe cafe, float cost, String name){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
    }
    
    @Override
    public String toString(){
        String string = cafe.getName() + "," + name + " = " + cost;
        return string;
    }
    
}
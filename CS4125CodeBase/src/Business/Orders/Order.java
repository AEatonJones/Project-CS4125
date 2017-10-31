package Business.Orders;

import Business.Profiles.Cafe;
import Data.MenuItem;

public abstract class Order implements Comparable<Order>{
    
<<<<<<< HEAD:CS4125CodeBase/src/Business/Order.java
    private MenuItem [] menuItems;
    private int etf;
    private String paymentType;
    
    public Order(MenuItem [] menuItems, String paymentType){
        this.menuItems = menuItems;
        this.paymentType = paymentType;
        this.etf = this.menuItems.length * 3;
    }
=======
    MenuItem [] items;
>>>>>>> origin/Code-base:CS4125CodeBase/src/Business/Orders/Order.java
    
    float surcharge;
    int baseEtf;
    
<<<<<<< HEAD:CS4125CodeBase/src/Business/Order.java

    public float getCost() {
=======
    public float getCost()
    {
>>>>>>> origin/Code-base:CS4125CodeBase/src/Business/Orders/Order.java
        float cost = 0.0f;
        
        for(MenuItem item : items)
            cost += item.getCost();
        
        cost += surcharge;
        
        return cost;
    }

    
<<<<<<< HEAD:CS4125CodeBase/src/Business/Order.java
    public Cafe getCafe() {
        return menuItems[0].getCafe();
=======
    public Cafe getCafe()
    {
        return items[0].getCafe();
>>>>>>> origin/Code-base:CS4125CodeBase/src/Business/Orders/Order.java
    }

    
    public int getEtf()
    {
        int etf = items.length;
        
        for(MenuItem item : items)
            etf += item.getEtf();
        
        etf += baseEtf;
        return etf;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    @Override
<<<<<<< HEAD:CS4125CodeBase/src/Business/Order.java
    public int compareTo(Order o) {
        int result = 0;
        
        if(this.etf < o.getEtf()){
            result--;
        }
=======
    public String toString(){
        String result = getCafe().getName();
>>>>>>> origin/Code-base:CS4125CodeBase/src/Business/Orders/Order.java
        
        for(MenuItem item : items)
            result += item.getName() + ", " + item.getCost();
        
        return result;
    }
    
    @Override
<<<<<<< HEAD:CS4125CodeBase/src/Business/Order.java
    public String toString() {
        String result = getCafe().getName();
=======
    public int compareTo(Order o){
        int result = 0;
>>>>>>> origin/Code-base:CS4125CodeBase/src/Business/Orders/Order.java
        
        if(this.getEtf() < o.getEtf())
            result--;
        
        else if(this.getEtf() > o.getEtf())
            result++;
        
        return result;
    }
}
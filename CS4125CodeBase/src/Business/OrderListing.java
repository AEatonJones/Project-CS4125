package Business;

import java.util.ArrayList;

public class OrderListing implements Listing<Order>{

    private ArrayList<Order> orderList = new ArrayList<Order>();
    
    public int getLength()
    {
        return orderList.size();
    }
    
    @Override
    public void sortListing(){
        orderList.sort(null);
    }

    @Override
    public void push(Order listItem){
        orderList.add(listItem);
        sortListing();
    }

    @Override
    public Order grab(int index)
    {
        return orderList.remove(index);
    } 
}

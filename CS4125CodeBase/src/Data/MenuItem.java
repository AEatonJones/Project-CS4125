package Data;

import Business.Profiles.Cafe;

public class MenuItem 
{
    private Cafe cafe;
    private String name;
    private float cost;
    private int etf;
    
    /**
     *Constructor.
     * @param cafe Cafe object.
     * @param name Name of the item..
     * @param cost Cost of the item.
     * @param etf Estimated time to finish of the item.
     */
    public MenuItem(Cafe cafe, String name, float cost, int etf){
        this.cafe = cafe;
        this.name = name;
        this.cost = cost;
        this.etf = etf;
    }
    
    /**
     *Gets the cost of the item.
     * @return The cost of the item.
     */
    public float getCost(){
        return this.cost;
    }
    /**Gets the name of the item.
     * @return The name of the item.
     */
    public String getName(){
        return this.name;
    }
    /**
     *Gets the cafe of the item.
     * @return The cafe of the item.
     */
    public Cafe getCafe(){
        return this.cafe;
    }

    /**
     *Gets the estimated time to finish.
     * @return  The estimated time to finish.
     */
    public int getEtf()
    {
        return this.etf;
    }
    /**
     *Converts the item to a string.
     * @return The item in string form.
     */
    @Override
    public String toString(){
        return name + " : \u20AC" + String.format("%.2f", cost);
    }
}

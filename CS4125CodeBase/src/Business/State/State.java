package Business.State;

public abstract class State
{
    String description;
    /**
     *gets the state which is either clocked in or clocked out.
     * @return Description which is either clocked in or clocked out.
     */
    public String getState() {
        return description;
    }
}

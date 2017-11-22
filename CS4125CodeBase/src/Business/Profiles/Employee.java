package Business.Profiles;

import Data.OrderDB;
import Business.Information_Managers.ProfileControl;
import Business.State.State;

public class Employee extends Customer implements State{
    
    private int id;
    private Cafe cafe;
    private String state;

    /**
     * Constructor.
     * @param firstname First name of employee.
     * @param surname Surname of employee.
     * @param email Employee account email.
     * @param password Employee account password.
     * @param number Employee phone number.
     * @param cafe Each employee holds their cafe object.
     */
    public Employee(String firstname, String surname, String email, String password, String number, Cafe cafe) {
        super(firstname,surname,email,password,number);
        this.cafe = cafe;
        this.id = ProfileControl.assignID(cafe);
        this.state = "Clocked-Out";
    }
    /**
     * getter which returns cafe.
     */
    public Cafe getCafe() {
        return cafe;
    }
    /**
     * getter which returns ID.
     */
    public int getID() {
        return id;
    }

    /**
     * Getter used to retrieve the state of the employee.
     * @return The state of employee(clocked in or out).
     */
    @Override
    public String getState()
    {
        return state;
    }
    /**
     * setter which sets state and is needed due to state interface.
     */
    @Override
    public void setState(String state)
    {
        this.state = state;
    }
    
    /**
     * sets state of employee to clocked in.
     */
    public void clockIn()
    {
        if(!(clockedIn()))
            setState("Clocked-In");
    }
    /**
     * sets state of employee to clocked out.
     */
    public void clockOut()
    {
        if(!(clockedOut()))
            setState("Clocked-Out");
    }
    
    /**
     * 
     */
    public boolean clockedIn() {
        return state.equals("Clocked-In");
    }
    /**
     * 
     */
    public boolean clockedOut() {
        return state.equals("Clocked-Out");
    }
}

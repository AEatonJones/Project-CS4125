package Business.Profiles;

import Data.OrderDB;
import Business.Information_Managers.ProfileControl;
import Business.State.ClockedIn;
import Business.State.ClockedOut;
import Business.State.State;

public class Employee extends Customer {
    
    private int id;
    private Cafe cafe;
    private State state;

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
        this.state = new ClockedOut();
    }
    /**
     * Getter used to retrieve the cafe of the employee.
     * @return The cafe of the employee.
     */
    public Cafe getCafe() {
        return cafe;
    }
    /**
     * Getter which is used to retrieve the id of the employee.
     * @return The id of the employee.
     */
    public int getID() {
        return id;
    }

    /**
     * Getter used to retrieve the state of the employee.
     * @return The state of employee(clocked in or out).
     */
    private State getState()
    {
        return state;
    }
    /**
     * Setter which sets state and is needed due to state interface.
     * 
     */
    public void setState(String state)
    {
        switch(state) {
            case "Clock-In": this.state = new ClockedIn();break;
            case "Clock-Out": this.state = new ClockedOut();break;
        }
    }
    
    /**
     * Sets state of employee to clocked in.
     */
    public void clockIn()
    {
        if(!(state instanceof ClockedIn))
            setState("Clock-In");
    }
    /**
     * Sets state of employee to clocked out.
     */
    public void clockOut()
    {
        if(!(state instanceof ClockedOut))
            setState("Clock-Out");
    }
    
    /**
     * Gets the state of the employee which is set to clocked in.
     * @return the state of the employee.
     */
    public boolean clockedIn() {
        return state.equals("Clocked-In");
    }
    /**
     * Gets the state of the employee which is set to clocked out.
     * @return the state of the employee.
     */
    public boolean clockedOut() {
        return state.equals("Clocked-Out");
    }
}

package Business.Profiles;

import Data.OrderDB;
import Business.Information_Managers.ProfileControl;
import Business.State.State;

public class Employee extends Customer implements State{
    
    private int id;
    private Cafe cafe;
    private String state;

    public Employee(String firstname, String surname, String email, String password, String number, Cafe cafe) {
        super(firstname,surname,email,password,number);
        this.cafe = cafe;
        this.id = ProfileControl.assignID(cafe);
        this.state = "Clocked-Out";
    }
    
    public Cafe getCafe() {
        return cafe;
    }
    
    public int getID() {
        return id;
    }

    @Override
    public String getState()
    {
        return state;
    }

    @Override
    public void setState(String state)
    {
        this.state = state;
    }
    
    public void clockIn()
    {
        if(!(clockedIn()))
            setState("Clocked-In");
    }
    
    public void clockOut()
    {
        if(!(clockedOut()))
            setState("Clocked-Out");
    }
    
    public boolean clockedIn() {
        return state.equals("Clocked-In");
    }
    
    public boolean clockedOut() {
        return state.equals("Clocked-Out");
    }
}

package Business.Profiles;

import Data.ProfileDB;

public abstract class Profile {
    private String number, email;
    /**
     * Constructor 
     * @param email Profile email.
     * @param number Profile number.
     */
    public Profile(String email, String number) {
        this.email = email;
        this.number = number;
    }
    /**
     * Getter which retrieves email of profile.
     * @return Email of profile.
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Getter which retrieves number of profile.
     * @return Number of profile.
     */
    public String getNumber() {
        return this.number;
    }
}


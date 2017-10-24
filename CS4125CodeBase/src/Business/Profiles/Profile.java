package Business.Profiles;

import Data.ProfileDB;

public abstract class Profile {
    private String number, email;
    
    public Profile(String email, String number) {
        this.email = email;
        this.number = number;
    }

}


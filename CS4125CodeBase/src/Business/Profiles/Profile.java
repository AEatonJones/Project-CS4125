package Business.Profiles;

import Data.ProfileDB;

public abstract class Profile {
    private String number, email, type;
    
    public Profile(String email, String number, String type) {
        
        this.email = email;
        this.number = number;
        this.type = type;

    }

}


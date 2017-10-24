package Data;

public class ProfileDB {
    
    private static ProfileDB instance = null;
    
    public static ProfileDB getInstance()
    {
        if(instance == null)
            instance = new ProfileDB();
        
        return instance;
    }
    
}

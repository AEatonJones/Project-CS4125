package Data;

import java.io.IOException;
/**
* Interface for interaction with the database.
*/
public interface Database<T> {
    public abstract void writeToFile(T data)throws IOException;
}

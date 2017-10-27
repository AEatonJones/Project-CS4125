package Data;

import java.io.IOException;

public interface Database<T> {
    public abstract void writeToFile(T data)throws IOException;
}

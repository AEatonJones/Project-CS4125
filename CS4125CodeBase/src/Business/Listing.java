
package Business;

public interface Listing<T>{
    public abstract void sortListing();
    public abstract void push(T listItem);
    public abstract T grab(int index);
}

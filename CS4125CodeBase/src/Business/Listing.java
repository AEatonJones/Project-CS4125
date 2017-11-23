
package Business;
/**
 * This is an interface which defines functionality for a generic listing of type T.
 */
public interface Listing<T>{
    /**
     * Sorts the given collection of T objects in the listing.
     */
    public abstract void sortListing();
    /**
     * Pushes a T object onto the listing.
     * @param listItem The T object.
     */
    public abstract void push(T listItem);
    /**
     * Picks a T object from the listing.
     * @param listItem The T object.
     */
    public abstract void pick(T listItem);
}

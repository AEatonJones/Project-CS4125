package Data;

public interface Subject
{
    public abstract void attachObserver(Business.Information_Managers.OrderObserver observer);
    public abstract void dettachObserver(Business.Information_Managers.OrderObserver observer);
    public abstract void notifyObservers(Business.Order order, String action);
}

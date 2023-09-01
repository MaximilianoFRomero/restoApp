package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Waiter;

public class WaiterController
{
    private List<Waiter> waiters;
    //Constructors
    public WaiterController()
    {
        this.waiters=new ArrayList();
    }
    //Functions
    public void addWaiter(int id,String name,String lastName)
    {
        this.waiters.add(new Waiter(id,name,lastName));
    }
    public void removeWaiter(int index)
    {
        this.waiters.remove(index);
    }
    public Waiter getWaiter(int index)
    {
        return this.waiters.get(index);
    }
}

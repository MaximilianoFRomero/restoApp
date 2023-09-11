package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Table;

public class TableController
{
    private List<Table> tables;
    private WaiterController waiterCont;
    public TableController()
    {
        this.tables=new ArrayList();
        this.waiterCont=new WaiterController();
    }
    //Getters and setters
    public WaiterController getWaiterController(){return this.waiterCont;}
    //Functions
    public void addTable(int id,int cutlery)
    {
        this.tables.add(new Table(id,cutlery));
    }
    public void removeTable(int index)
    {
        this.tables.remove(index);
    }
    public Table getTable(int index)
    {
        return this.tables.get(index);
    }
}

package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Table;

public class TableController
{
    private List<Table> tables;
    public TableController()
    {
        this.tables=new ArrayList();
    }
    //Functions
    public void addTable(String id)
    {
        this.tables.add(new Table(id));
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

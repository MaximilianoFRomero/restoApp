package restobar.Models;

import java.util.List;
import java.util.ArrayList;

public class Table {
    private String id;
    private List<Order> orderList;
    public Table(String id)
    {
        this.id=id;
        this.orderList=new ArrayList();
    }
}

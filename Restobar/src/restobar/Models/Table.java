package restobar.Models;

import java.util.List;
import java.util.ArrayList;

public class Table//Mesa
{
    private String id;
    private List<Order> orders;
    //Constructors
    public Table(String id)
    {
        this.id=id;
        this.orders=new ArrayList();
    }
    //Getters and setters
    public String getId(){return this.id;}
    public void setId(String id){this.id=id;}
    //Funcitions
    public void addOrder(List<Product> products)
    {
        Order order=new Order();
        int size=products.size();
        for(int i=0;i<size;i++)
        {
            order.addProduct(products.get(i));
        }
        this.orders.add(order);
    }
    public void removeOrder(int index)
    {
        this.orders.remove(index);
    }
    public Order getOrder(int index)
    {
        return this.orders.get(index);
    }
}

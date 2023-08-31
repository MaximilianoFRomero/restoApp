package restobar.Models;

import java.util.List;
import java.util.ArrayList;

public class Table//Mesa
{
    private int id;
    private int cutlery;//Cubiertos
    private List<Order> orders;
    //Constructors
    public Table(int id,int cutlery)
    {
        this.id=id;
        this.cutlery=cutlery;
        this.orders=new ArrayList();
    }
    //Getters and setters
    public int getId(){return this.id;}
    public int getCutlery(){return this.cutlery;}
    public void setId(int id){this.id=id;}
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
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

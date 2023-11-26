package restobar.Models;

import java.util.Date;

public class Table//Mesa
{
    private int id;
    private String name;
    private Order order;
    //Constructors
    public Table()
    {
        this.id=0;
        this.name="";
        this.order=new Order();
    }
    public Table(int id,String name,Order order)
    {
        this.id=id;
        this.name=name;
        this.order=order;
    }
    public Table(int id,String name)
    {
        this.id=id;
        this.name=name;
        this.order=new Order();
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public Order getOrder(){return this.order;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setOrder(Order order){this.order=order;}
    //Functions
    public void startNewOrder(Order newOrder)
    {
        if(order.getId()!=1)
            this.order=newOrder;
    }
    public Order endCurrentOrder()
    {
        this.order.setDateClose(new Date());
        return this.order;
    }
}

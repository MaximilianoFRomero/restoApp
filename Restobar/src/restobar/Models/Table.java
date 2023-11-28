package restobar.Models;

import java.util.Date;

/**
 *
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Table//Mesa
{
    private int id;
    private String name;
    private Order order;
    //Constructors

    /**
     * It create an instance of class Table
     */
    public Table()
    {
        this.id=0;
        this.name="";
        this.order=new Order();
    }

    /**
     *
     * @param id it represents a table id
     * @param name it represents a table name
     * @param order it represents a table order
     */
    public Table(int id,String name,Order order)
    {
        this.id=id;
        this.name=name;
        this.order=order;
    }

    /**
     *
     * @param id
     * @param name
     */
    public Table(int id,String name)
    {
        this.id=id;
        this.name=name;
        this.order=new Order();
    }
    //Getters and setters

    /**
     *Gets table id
     * @return id
     */
    public int getId(){return this.id;}

    /**
     *Gets table name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     *Gets table order
     * @return order
     */
    public Order getOrder(){return this.order;}

    /**
     *Sets table id
     * @param id
     */
    public void setId(int id){this.id=id;}

    /**
     *Sets table name
     * @param name
     */
    public void setName(String name){this.name=name;}

    /**
     *Sets table order
     * @param order
     */
    public void setOrder(Order order){this.order=order;}
    //Functions

    /**
     *Creates a new table order
     * @param newOrder
     */
    public void startNewOrder(Order newOrder)
    {
        if(order.getId()!=1)
            this.order=newOrder;
    }

    /**
     *Closes current table active order
     * @return oldOrder
     */
    public Order endCurrentOrder()
    {
        Order oldOrder=this.order;
        oldOrder.setDateClose(new Date());
        return oldOrder;
    }
    public String toString()
    {
        return this.name;
    }
}

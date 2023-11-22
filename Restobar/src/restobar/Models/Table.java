package restobar.Models;

public class Table//Mesa
{
    private int id;
    private String name;
    private Order order;
    //Constructors
    public Table(){}
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
}

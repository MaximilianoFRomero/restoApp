package restobar.Models;

public class Table//Mesa
{
    private int id;
    private int cutlery;//Cubiertos
    private Order order;
    private Waiter waiter;
    //Constructors
    public Table(int id,int cutlery)
    {
        this.id=id;
        this.cutlery=cutlery;
        this.order=new Order();
    }
    //Getters and setters
    public int getId(){return this.id;}
    public int getCutlery(){return this.cutlery;}
    public Order getOrder(){return this.order;}
    public Waiter getWaiter(){return this.waiter;}
    public void setId(int id){this.id=id;}
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
    public void setWaiter(Waiter waiter){this.waiter=waiter;}
    public void setOrder(Order order){this.order=order;}
    //Funcitions
    @Override
    public String toString()
    {
        String s="Table{\n";
        s+="id: "+this.id+",\n";
        s+="cutlery: "+this.cutlery+",\n";
        s+=this.order.toString()+",\n";
        s+=waiter.toString();
        s+="}";
        return s;
    }
}

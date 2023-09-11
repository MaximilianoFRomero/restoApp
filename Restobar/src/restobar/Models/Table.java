package restobar.Models;

public class Table//Mesa
{
    private int idTable;
    private int cutlery;//Cubiertos
    private Order order;
    private Waiter waiter;
    //Constructors
    public Table(int idTable,int cutlery)
    {
        this.idTable=idTable;
        this.cutlery=cutlery;
        this.order=new Order();
    }
    //Getters and setters
    public int getIdTable(){return this.idTable;}
    public int getCutlery(){return this.cutlery;}
    public Order getOrder(){return this.order;}
    public Waiter getWaiter(){return this.waiter;}
    public void setIdTable(int idTable){this.idTable=idTable;}
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
    public void setWaiter(Waiter waiter){this.waiter=waiter;}
    public void setOrder(Order order){this.order=order;}
    //Funcitions
    @Override
    public String toString()
    {
        String s="Table{\n";
        s+="id: "+this.idTable+",\n";
        s+="cutlery: "+this.cutlery+",\n";
        s+=this.order.toString()+",\n";
        s+=waiter.toString();
        s+="}";
        return s;
    }
}

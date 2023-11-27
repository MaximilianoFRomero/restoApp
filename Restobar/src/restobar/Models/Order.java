package restobar.Models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order//Pedido
{
    private int id;
    private int idTable;
    private Waiter waiter;
    private int cutlery;
    private Date dateOpen;
    private Date dateClose;
    private List<Item> items;
    //Constructors
    public Order()
    {
        this.id=1;
        this.idTable=1;
        this.waiter=new Waiter();
        this.cutlery=0;
        this.dateOpen=new Date();
        this.dateClose=null;
        this.items=new ArrayList();
    }
    public Order(int id,int idTable,Waiter waiter,int cutlery,Date dateOpen,Date dateClose)
    {
        this.id=id;
        this.idTable=idTable;
        this.cutlery=cutlery;
        this.dateOpen=dateOpen;
        this.dateClose=dateClose;
        this.items=new ArrayList();
    }
    //Getters and setters
    public int getId(){return this.id;}
    public int getIdTable(){return this.idTable;}
    public Waiter getWaiter(){return this.waiter;}
    public int getCutlery(){return this.cutlery;}
    public Date getDateOpen(){return this.dateOpen;}
    public Date getDateClose(){return this.dateClose;}
    public void setId(int id){this.id=id;}
    public void setIdTable(int idTable){this.idTable=idTable;}
    public void setWaiter(Waiter waiter){this.waiter=waiter;}
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
    public void setDateOpen(Date dateOpen){this.dateOpen=dateOpen;}
    public void setDateClose(Date dateClose){this.dateClose=dateClose;}
    //Functions
    public void addItem(Item item)
    {
        this.items.add(item);
    }
    public void removeItem(int index)
    {
        this.items.remove(index);
    }
    public Item getItem(int index)
    {
        return this.items.get(index);
    }
    public void addItems(List<Item> itemsToAdd)
    {
        for(int i=0;i<itemsToAdd.size();i++)
            items.add(itemsToAdd.get(i));
    }
    public List<Item> getItems()
    {
        return this.items;
    }
    public float calculatePrice()
    {
        float result=0;
        for(int i=0;i<items.size();i++)
            result+=items.get(i).calculateTotalPrice();
        return result;
    }
}


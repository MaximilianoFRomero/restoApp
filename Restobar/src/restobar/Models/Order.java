package restobar.Models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order//Pedido
{
    private float amountPaid;//Monto pagado
    private Date dateOpen;
    private Date dateClose;
    private List<Item> items;
    //Constructors
    public Order()
    {
        this.items=new ArrayList();
        this.amountPaid=0;
        this.dateOpen=new Date();
    }
    public Order(List<Item> items)
    {
        this.items=items;
    }
    //Getters and setters
    public float getAmountPaid(){return this.amountPaid;}
    public Date getDateOpen(){return this.dateOpen;}
    public Date getDateClose(){return this.dateClose;}
    public void setDateOpen(Date dateOpen){this.dateOpen=dateOpen;}
    public void setDateClose(Date dateClose){this.dateClose=dateClose;}
    public void setAmountPaid(float amountPaid){this.amountPaid=amountPaid;}
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
    public float calculatePrice()
    {
        float result=0;
        for(Item item: items)
            result+=item.calculateTotalPrice();
        return result;
    }
}


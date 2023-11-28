package restobar.Models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Order//Pedido
{
    /**
     * It represents the Order ID
     */
    private int id;
    /**
     * It represents the Table ID
     */
    private int idTable;
    /**
     * It represents a Waiter element
     */
    private Waiter waiter;
    /**
     * It represents the Order cutlery
     */
    private int cutlery;
    /**
     * It represents the Order open Date Time
     */
    private Date dateOpen;
    /**
     * It represents the Order close Date Time
     */
    private Date dateClose;
    /**
     * It represents a Item List
     */
    private List<Item> items;
    //Constructors
    /**
     * It create an instance of class Order
     */
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
    /**
     * 
     * @param id It represents the Order ID
     * @param idTable It represents the Table ID
     * @param waiter It represents a Waiter element
     * @param cutlery It represents the Order cutlery
     * @param dateOpen It represents the Order open Date Time
     * @param dateClose It represents the Order close Date Time
     */
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
    /**
     * Gets order id
     * @return id
     */
    public int getId(){return this.id;}
    /**
     * Gets table id
     * @return tableid
     */
    public int getIdTable(){return this.idTable;}
    /**
     * Gets waiter
     * @return waiter
     */
    public Waiter getWaiter(){return this.waiter;}
    /**
     * Gets order cutlery
     * @return cutlery
     */
    public int getCutlery(){return this.cutlery;}
    /**
     * Gets order open date time
     * @return dateOpen
     */
    public Date getDateOpen(){return this.dateOpen;}
    /**
     * Gets order close date time
     * @return dateClose
     */
    public Date getDateClose(){return this.dateClose;}
    /**
     * Sets order id
     * @param id 
     */
    public void setId(int id){this.id=id;}
    /**
     * Sets table id
     * @param idTable 
     */
    public void setIdTable(int idTable){this.idTable=idTable;}
    /**
     * Sets waiter
     * @param waiter 
     */
    public void setWaiter(Waiter waiter){this.waiter=waiter;}
    /**
     * Sets order cutlery
     * @param cutlery 
     */
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
    /**
     * Sets order open date time
     * @param dateOpen 
     */
    public void setDateOpen(Date dateOpen){this.dateOpen=dateOpen;}
    /**
     * Sets order close date time
     * @param dateClose 
     */
    public void setDateClose(Date dateClose){this.dateClose=dateClose;}
    //Functions
    /**
     * Adds item to order
     * @param item 
     */
    public void addItem(Item item)
    {
        this.items.add(item);
    }
    /**
     * Removes item from order
     * @param index 
     */
    public void removeItem(int index)
    {
        this.items.remove(index);
    }
    /**
     * Gets item from order
     * @param index
     * @return item
     */
    public Item getItem(int index)
    {
        return this.items.get(index);
    }
    /**
     * Adds items to item list
     * @param itemsToAdd 
     */
    public void addItems(List<Item> itemsToAdd)
    {
        for(int i=0;i<itemsToAdd.size();i++)
            items.add(itemsToAdd.get(i));
    }
    /**
     * Gets items from item list
     * @return items
     */
    public List<Item> getItems()
    {
        return this.items;
    }
    /**
     * Calculates order price
     * @return result - order price
     */
    public float calculatePrice()
    {
        float result=0;
        for(int i=0;i<items.size();i++)
            result+=items.get(i).calculateTotalPrice();
        return result;
    }
}


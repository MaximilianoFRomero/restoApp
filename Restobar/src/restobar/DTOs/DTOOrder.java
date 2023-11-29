package restobar.DTOs;

import java.util.Date;

public class DTOOrder
{
    private int id;
    private int idTable;
    private int idWaiter;
    private int cutlery;
    private Date dateOpen;
    private Date dateClose;
    private float totalPrice;
    //Constructors
    public DTOOrder(){}
    public DTOOrder(int id,int idTable,int idWaiter,int cutlery,Date dateOpen,Date dateClose,float totalPrice)
    {
        this.id=id;
        this.idTable=idTable;
        this.idWaiter=idWaiter;
        this.cutlery=cutlery;
        this.dateOpen=dateOpen;
        this.dateClose=dateClose;
        this.totalPrice=totalPrice;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public int getIdTable(){return this.idTable;}
    public int getIdWaiter(){return this.idWaiter;}
    public int getCutlery(){return this.cutlery;}
    public Date getDateOpen(){return this.dateOpen;}
    public Date getDateClose(){return this.dateClose;}
    public float getTotalPrice(){return this.totalPrice;}
    public void setId(int id){this.id=id;}
    public void setIdTable(int idTable){this.idTable=idTable;}
    public void setIdWaiter(int idWaiter){this.idWaiter=idWaiter;}
    public void setCutlery(int cutlery){this.cutlery=cutlery;}
    public void setDateOpen(Date dateOpen){this.dateOpen=dateOpen;}
    public void setDateClose(Date dateClose){this.dateClose=dateClose;}
    public void setTotalPrice(float totalPrice){this.totalPrice=totalPrice;}
}

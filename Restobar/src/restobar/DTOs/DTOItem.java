package restobar.DTOs;

import java.util.Objects;

public class DTOItem
{
    private int idProduct;
    private int idOrder;
    private int totalProduct;
    private float individualPrice;
    //Constructors
    public DTOItem(){}
    public DTOItem(int idProduct,int idOrder,int totalProduct,float individualPrice)
    {
        this.idProduct=idProduct;
        this.idOrder=idOrder;
        this.totalProduct=totalProduct;
        this.individualPrice=individualPrice;
    }
    //Getters and setters
    public int getIdProduct(){return this.idProduct;}
    public int getIdOrder(){return this.idOrder;}
    public int getTotalProduct(){return this.totalProduct;}
    public float getIndividualPrice(){return this.individualPrice;}
    public void setIdProduct(int idProduct){this.idProduct=idProduct;}
    public void setIdOrder(int idOrder){this.idOrder=idOrder;}
    public void setTotalProduct(int totalProduct){this.totalProduct=totalProduct;}
    public void setIndividualPrice(float individualPrice){this.individualPrice=individualPrice;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.idProduct^(this.idProduct>>>32));
        hash=29*hash+(int) (this.idOrder^(this.idOrder>>>32));
        hash=29*hash+this.totalProduct;
        hash=29*hash+(int) this.individualPrice;
        return hash;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }
        if(obj==null)
        {
            return false;
        }
        if(this.getClass()!=obj.getClass())
        {
            return false;
        }
        
        final DTOItem other=(DTOItem) obj;
        if(this.idProduct!=other.getIdProduct())
        {
            return false;
        }
        if(this.idOrder!=other.getIdOrder())
        {
            return false;
        }
        if(this.totalProduct!=other.getTotalProduct())
        {
            return false;
        }
        return individualPrice==other.getIndividualPrice();
    }
    @Override
    public String toString()
    {
        String s="DTOItem{";
        s+="\"idProduct\":"+this.idProduct+",";
        s+="\"idOrder\":"+this.idOrder+",";
        s+="\"totalProduct\":"+this.totalProduct+",";
        s+="\"individualPrice\":"+this.individualPrice;
        s+="}";
        return s;
    }
}

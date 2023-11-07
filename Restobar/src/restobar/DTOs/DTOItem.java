package restobar.DTOs;

import java.util.Objects;

public class DTOItem
{
    private long idProduct;
    private long idOrder;
    private int totalProduct;
    //Constructors
    public DTOItem(){}
    public DTOItem(long idProduct,long idOrder,int totalProduct)
    {
        this.idProduct=idProduct;
        this.idOrder=idOrder;
        this.totalProduct=totalProduct;
    }
    //Getters and setters
    public long getIdProduct(){return this.idProduct;}
    public long getIdOrder(){return this.idOrder;}
    public int getTotalProduct(){return this.totalProduct;}
    public void setIdProduct(long idProduct){this.idProduct=idProduct;}
    public void setIdOrder(long idOrder){this.idOrder=idOrder;}
    public void setTotalProduct(int totalProduct){this.totalProduct=totalProduct;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.idProduct^(this.idProduct>>>32));
        hash=29*hash+(int) (this.idOrder^(this.idOrder>>>32));
        hash=29*hash+this.totalProduct;
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
        return this.totalProduct==other.getTotalProduct();
    }
    @Override
    public String toString()
    {
        String s="DTOItem{";
        s+="\"idProduct\":"+this.idProduct+",";
        s+="\"idOrder\":"+this.idOrder+",";
        s+="\"totalProduct\":"+this.totalProduct;
        s+="}";
        return s;
    }
}

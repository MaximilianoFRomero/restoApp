package restobar.Models;

public class Item
{
    private long idProduct;
    private long idOrder;
    private int totalProduct;
    //Constructors
    public Item()
    {
        this.idProduct=0;
        this.idOrder=0;
        this.totalProduct=0;
    }
    public Item(long idProduct,long idOrder,int totalProduct)
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
}

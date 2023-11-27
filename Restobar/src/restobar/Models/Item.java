package restobar.Models;

public class Item
{
    private Product product;
    private int idOrder;
    private int totalProduct;
    private float individualPrice;
    //Constructors
    public Item(){}
    public Item(Product product,int idOrder,int totalProduct)
    {
        this.product=product;
        this.idOrder=idOrder;
        this.totalProduct=totalProduct;
        this.individualPrice=product.getPrice().getValue();
    }
    //Getters and setters
    public Product getProduct(){return this.product;}
    public int getIdOrder(){return this.idOrder;}
    public int getTotalProduct(){return this.totalProduct;}
    public float getIndividualPrice(){return this.individualPrice;}
    public void setProduct(Product product){this.product=product;}
    public void setIdOrder(int idOrder){this.idOrder=idOrder;}
    public void setTotalProduct(int totalProduct){this.totalProduct=totalProduct;}
    public void setIndividualPrice(float individualPrice){this.individualPrice=individualPrice;}
    //Functions
    public float calculateTotalPrice()
    {
        return this.individualPrice*totalProduct;
    }
}

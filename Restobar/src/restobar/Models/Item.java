package restobar.Models;

public class Item
{
    Product product;
    int totalProduct;
    //Constructors
    public Item(Product product,int totalProduct)
    {
        this.product=product;
        this.totalProduct=totalProduct;
    }
    //Getters and setters
    public Product getProduct(){return this.product;}
    public int getTotalProduct(){return this.totalProduct;}
    public void setProduct(Product product){this.product=product;}
    public void setTotalProduct(int totalProduct){this.totalProduct=totalProduct;}
}

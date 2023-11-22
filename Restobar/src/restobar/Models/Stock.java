package restobar.Models;

public class Stock
{
    private Product product;
    private int total;
    //Constructors
    public Stock(){}
    public Stock(Product product,int total)
    {
        this.product=product;
        this.total=total;
    }
    //Getters and setters
    public Product getProduct(){return this.product;}
    public int getTotal(){return this.total;}
    public void setProduct(Product product){this.product=product;}
    public void setTotal(int total){this.total=total;}
    //Functions
    public void changeTotal(int modification)
    {
        this.total+=modification;
    }
}

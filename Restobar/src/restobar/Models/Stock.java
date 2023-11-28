package restobar.Models;

/**
 *
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Stock
{
    private Product product;
    private int total;
    //Constructors

    /**
     * It create an instance of class Stock
     */
    public Stock(){}

    /**
     *
     * @param product it represents a product
     * @param total it represents a total quantity of a product
     */
    public Stock(Product product,int total)
    {
        this.product=product;
        this.total=total;
    }
    //Getters and setters

    /**
     * Gets product
     * @return product
     */
    public Product getProduct(){return this.product;}

    /**
     * Gets total quantity
     * @return total
     */
    public int getTotal(){return this.total;}

    /**
     * Sets product
     * @param product
     */
    public void setProduct(Product product){this.product=product;}

    /**
     * Sets total quantity
     * @param total
     */
    public void setTotal(int total){this.total=total;}
    //Functions

    /**
     * Changes total quantity of a product stock
     * @param modification
     */
    public void changeTotal(int modification)
    {
        this.total+=modification;
    }
}

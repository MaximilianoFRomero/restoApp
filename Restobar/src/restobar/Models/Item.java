package restobar.Models;
/**
 * 
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Item
{
    /**
     * It represents the Product Item
     */
    private Product product;
    /**
     * It represents the order ID
     */
    private int idOrder;
    /**
     * It represents the Item total product
     */
    private int totalProduct;
    /**
     * It represents the individual Item price
     */
    private float individualPrice;
    //Constructors
    /**
     * It create an instance of class Item
     */
    public Item(){}
     /**
      * 
      * @param product It represents the Product Item
      * @param idOrder It represents the order ID
      * @param totalProduct It represents the Item total product
      */
    public Item(Product product,int idOrder,int totalProduct)
    {
        this.product=product;
        this.idOrder=idOrder;
        this.totalProduct=totalProduct;
        this.individualPrice=product.getPrice().getValue();
    }
    //Getters and setters
    /**
     * Gets product
     * @return product
     */
    public Product getProduct(){return this.product;}
    /**
     * Gets Order Id
     * @return idOrder
     */
    public int getIdOrder(){return this.idOrder;}
    /**
     * Gets total product
     * @return totalProduct
     */
    public int getTotalProduct(){return this.totalProduct;}
    /**
     * Gets Individual item price
     * @return individualPrice
     */
    public float getIndividualPrice(){return this.individualPrice;}
    /**
     * Sets product
     * @param product 
     */
    public void setProduct(Product product){this.product=product;}
    /**
     * Sets Order Id
     * @param idOrder 
     */
    public void setIdOrder(int idOrder){this.idOrder=idOrder;}
    /**
     * Sets total product
     * @param totalProduct 
     */
    public void setTotalProduct(int totalProduct){this.totalProduct=totalProduct;}
    /**
     * Sets Individual item price
     * @param individualPrice 
     */
    public void setIndividualPrice(float individualPrice){this.individualPrice=individualPrice;}
    //Functions
    /**
     * Calculates total total price
     * @return total price
     */
    public float calculateTotalPrice()
    {
        return this.individualPrice*totalProduct;
    }
}

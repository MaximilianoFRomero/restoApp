package restobar.Models;

/**
 *
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Product//Producto
{
    private int id;
    private String name;
    private String description;
    private Price price;
    private Category category;
    //Constructors

    /**
     *It create an instance of class Product
     */
    public Product()
    {
        this.id=0;
        this.name="";
        this.description="";
        this.price=new Price(0);
        this.category=new Category();
    }

    /**
     *
     * @param id It represents product id
     * @param name It represents product name
     * @param description It represents product description
     * @param price It represents product price
     * @param category It represents product category
     */
    public Product(int id,String name,String description,float price,Category category)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=new Price(price);
        this.category=category;
    }
    //Getters and setters

    /**
     * Gets product id
     * @return id
     */
    public int getId(){return this.id;}

    /**
     * Gets product name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     *Gets product description
     * @return description
     */
    public String getDescription(){return this.description;}

    /**
     * Gets product price
     * @return price
     */
    public Price getPrice(){return this.price;}

    /**
     * Gets product category
     * @return category
     */
    public Category getCategory(){return this.category;}

    /**
     *Sets product id
     * @param idProduct
     */
    public void setId(int idProduct){this.id=idProduct;}

    /**
     * Sets product name
     * @param name
     */
    public void setName(String name){this.name=name;}

    /**
     * Sets product description
     * @param description
     */
    public void setDescription(String description){this.description=description;}

    /**
     * Sets product price
     * @param price
     */
    public void setPrice(Price price){this.price=price;}

    /**
     * Sets product category
     * @param category
     */
    public void setCategory(Category category){this.category=category;}
}

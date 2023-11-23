package restobar.Models;

public class Product//Producto
{
    private int id;
    private String name;
    private String description;
    private Price price;
    private Category category;
    //Constructors
    public Product()
    {
        this.id=0;
        this.name="";
        this.description="";
        this.price=new Price(0);
        this.category=new Category();
    }
    public Product(int id,String name,String description,float price,Category category)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=new Price(price);
        this.category=category;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public Price getPrice(){return this.price;}
    public Category getCategory(){return this.category;}
    public void setId(int idProduct){this.id=idProduct;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(Price price){this.price=price;}
    public void setCategory(Category category){this.category=category;}
}

package restobar.Models;

public class Product//Producto
{
    private int idProduct;
    private String name;
    private String description;
    private Price price;
    private Boolean elaborated;
    private Category category;
    //Constructors
    public Product()
    {
        this.name="";
        this.description="";
        this.price=new Price(0);
        this.elaborated=false;
        this.category=new Category();
    }
    public Product(int idProduct,String name,String description,float price,Boolean elaborated,Category category)
    {
        this.idProduct=idProduct;
        this.name=name;
        this.description=description;
        this.price=new Price(price);
        this.elaborated=elaborated;
        this.category=category;
    }
    //Getters and setters
    public int getIdProduct(){return this.idProduct;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public Price getPrice(){return this.price;}
    public Boolean getElaborated(){return this.elaborated;}
    public Category getCategory(){return this.category;}
    public void setIdProduct(int idProduct){this.idProduct=idProduct;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(Price price){this.price=price;}
    public void setElaborated(Boolean elaborated){this.elaborated=elaborated;}
    public void setCategory(Category category){this.category=category;}
    //Functions
    @Override
    public String toString()
    {
        String s = "Product{\n";
        s+="id: \""+idProduct+"\",\n";
        s+="name: \""+name+"\",\n";
        s+="description: \""+description+"\",\n";
        //s+="price: "+price+",\n";
        s+="elaborated: "+elaborated+",\n";
        s+="category: "+category+"\n";
        s+="}";
        return s;
    }
}

package restobar.Models;

public class Product//Producto
{
    private String name;
    private String description;
    private int price;
    private Boolean elaborated;
    private int category;
    //Constructors
    public Product()
    {
        this.name="";
        this.description="";
        this.price=0;
        this.elaborated=false;
        this.category=0;
    }
    public Product(String name,String description,int price,Boolean elaborated,int category)
    {
        this.name=name;
        this.description=description;
        this.price=price;
        this.elaborated=elaborated;
        this.category=category=0;
    }
    //Getters and setters
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public int getPrice(){return this.price;}
    public Boolean getElaborated(){return this.elaborated;}
    public int getCategory(){return this.category;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(int price){this.price=price;}
    public void setElaborated(Boolean elaborated){this.elaborated=elaborated;}
    public void setCategory(int category){this.category=category;}
    //Functions
    @Override
    public String toString()
    {
        String s = "Product{\n";
        s+="name: \""+name+"\",\n";
        s+="description: \""+description+"\",\n";
        s+="price: "+price+",\n";
        s+="elaborated: "+elaborated+",\n";
        s+="category: "+category+"\n";
        s+="}";
        return s;
    }
}

package restobar.Models;

public class Product//Producto
{
    private int id;
    private String name;
    private String description;
    private Price price;
    private int stock;
    private Category category;
    //Constructors
    public Product()
    {
        this.id=0;
        this.name="";
        this.description="";
        this.price=new Price(0);
        this.stock=-1;
        this.category=new Category();
    }
    public Product(int id,String name,String description,float price,int stock,Category category)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=new Price(price);
        this.stock=stock;
        this.category=category;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public Price getPrice(){return this.price;}
    public int getStock(){return this.stock;}
    public Category getCategory(){return this.category;}
    public void setId(int idProduct){this.id=idProduct;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(Price price){this.price=price;}
    public void setStock(int stock){this.stock=stock;}
    public void setCategory(Category category){this.category=category;}
    //Functions
    public Boolean isElaborated()
    {
        Boolean b=false;
        if(this.stock<0)//Check if the product it has an stock or it's elaborated int the place
            b=true;
        return b;
    }
    public Boolean changeStock(int modification)
    {
        Boolean result=false;
        if(!isElaborated())
        {
            if(this.stock+modification>=0)
            {
                this.stock+=modification;
                result=true;
            }else
            {
                result=false;
            }
        }
        return result;
    }
}

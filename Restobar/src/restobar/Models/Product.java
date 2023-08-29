package restobar.Models;

public class Product {
    private String name;
    private String description;
    private float cost;
    private float price;
    private Boolean elaborated;
    public Product()
    {
        this.name="";
        this.description="";
        this.cost=(float)0;
        this.price=(float)0;
        this.elaborated=false;
    }
    public Product(String name,String description,float cost,float price,Boolean elaborated)
    {
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.price=price;
        this.elaborated=elaborated;
    }
    //Getters and Setters
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public float getCost(){return this.cost;}
    public float getPrice(){return this.price;}
    public Boolean getElaborated(){return this.elaborated;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setCost(float cost){this.cost=cost;}
    public void setPrice(float price){this.price=price;}
    public void setElaborated(Boolean elaborated){this.elaborated=elaborated;}
}

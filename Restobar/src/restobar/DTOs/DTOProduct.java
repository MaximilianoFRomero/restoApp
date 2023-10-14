package restobar.DTOs;

import java.util.Objects;

public class DTOProduct
{
    private int id;
    private String name;
    private String description;
    float price;
    //Constructors
    public DTOProduct(){}
    public DTOProduct(int id,String name,String description,float price)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public float getPrice(){return this.price;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(float price){this.price=price;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.id^(this.id>>>32));
        hash=29*hash+Objects.hashCode(this.name);
        hash=29*hash+Objects.hashCode(this.description);
        hash=29*hash+(int)this.price;
        return hash;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }
        if(obj==null)
        {
            return false;
        }
        if(this.getClass()!=obj.getClass())
        {
            return false;
        }
        
        final DTOProduct other=(DTOProduct) obj;
        if(this.id!=other.getId())
        {
            return false;
        }
        if(!Objects.equals(this.name,other.getName()))
        {
            return false;
        }
        if(!Objects.equals(this.description, other.getDescription()))
        {
            return false;
        }
        return this.price==other.getPrice();
    }
    @Override
    public String toString()
    {
        String s="DTOProduct{";
        s+="\"id\":"+this.id+",";
        s+="\"name\":"+this.name+",";
        s+="\"description\":"+this.description+",";
        s+="\"price\":"+this.price;
        s+="}";
        return s;
    }
}

package restobar.DTOs;

import java.util.Objects;

public class DTOProduct
{
    private int id;
    private String name;
    private String description;
    private float price;
    private int idCategory;
    //Constructors
    public DTOProduct(){}
    public DTOProduct(int id,String name,String description,float price,int idCategory)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.idCategory=idCategory;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public float getPrice(){return this.price;}
    public int getIdCategory(){return this.idCategory;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setPrice(float price){this.price=price;}
    public void setIdCategory(int idCategory){this.idCategory=idCategory;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.id^(this.id>>>32));
        hash=29*hash+Objects.hashCode(this.name);
        hash=29*hash+Objects.hashCode(this.description);
        hash=29*hash+(int)this.price;
        hash=29*hash+(int)this.idCategory;
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
        if(this.price!=other.getPrice())
        {
            return false;
        }
        return this.idCategory==other.getIdCategory();
    }
    @Override
    public String toString()
    {
        String s="DTOProduct{";
        s+="\"id\":"+this.id+",";
        s+="\"name\":"+this.name+",";
        s+="\"description\":"+this.description+",";
        s+="\"price\":"+this.price+",";
        s+="\"idCategory\":"+this.idCategory;
        s+="}";
        return s;
    }
}

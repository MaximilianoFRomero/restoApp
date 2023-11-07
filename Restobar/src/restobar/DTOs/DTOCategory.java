package restobar.DTOs;

import java.util.Objects;

public class DTOCategory
{
    private int id;
    private String name;
    //Constructors
    public DTOCategory(){}
    public DTOCategory(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.id^(this.id>>>32));
        hash=29*hash+Objects.hashCode(this.name);
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
        
        final DTOCategory other=(DTOCategory) obj;
        if(this.id!=other.getId())
        {
            return false;
        }
        return Objects.equals(this.name,other.getName());
    }
    @Override
    public String toString()
    {
        String s="DTOCategory{";
        s+="\"id\":"+this.id+",";
        s+="\"name\":"+this.name;
        s+="}";
        return s;
    }
}

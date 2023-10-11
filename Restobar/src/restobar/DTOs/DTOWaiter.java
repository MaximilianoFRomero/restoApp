package restobar.DTOs;

import java.util.Objects;

public class DTOWaiter
{
    private int id;
    private String name;
    private String lastName;
    //Constructors
    public DTOWaiter(){}
    public DTOWaiter(int id,String name,String lastName)
    {
        this.id=id;
        this.name=name;
        this.lastName=lastName;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getLastName(){return this.lastName;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setLastName(String lastName){this.lastName=lastName;}
    //Functions
    @Override
    public int hashCode()
    {
        int hash=3;
        hash=29*hash+(int) (this.id^(this.id>>>32));
        hash=29*hash+Objects.hashCode(this.name);
        hash=29*hash+Objects.hashCode(this.lastName);
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
        
        final DTOWaiter other=(DTOWaiter) obj;
        if(this.id!=other.getId())
        {
            return false;
        }
        if(!Objects.equals(this.name,other.getName()))
        {
            return false;
        }
        return Objects.equals(this.name,other.getName());
    }
    @Override
    public String toString()
    {
        String s="DTOWaiter{";
        s+="\"id\":"+this.id+",";
        s+="\"name\":"+this.name+",";
        s+="\"lastName\":"+this.lastName;
        s+="}";
        return s;
    }
}

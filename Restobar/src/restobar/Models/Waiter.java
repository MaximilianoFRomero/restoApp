package restobar.Models;

public class Waiter
{
    private long id;
    private String name;
    private String lastName;
    //Constructors
    public Waiter()
    {
        this.id=0;
        this.name="";
        this.lastName="";
    }
    public Waiter(long idWaiter,String name,String lastName)
    {
        this.id=id;
        this.name=name;
        this.lastName=lastName;
    }
    //Getters and setters
    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public String getLastName(){return this.lastName;}
    public void setId(long idWaiter){this.id=idWaiter;}
    public void setName(String name){this.name=name;}
    public void setLastName(String lastName){this.lastName=lastName;}
}

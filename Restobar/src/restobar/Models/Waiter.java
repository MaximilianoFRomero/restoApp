package restobar.Models;

public class Waiter
{
    private int idWaiter;
    private String name;
    private String lastName;
    //Constructors
    public Waiter(int idWaiter,String name,String lastName)
    {
        this.idWaiter=idWaiter;
        this.name=name;
        this.lastName=lastName;
    }
    //Getters and setters
    public int getIdWaiter(){return this.idWaiter;}
    public String getName(){return this.name;}
    public String getLastName(){return this.lastName;}
    public void setIdWaiter(int idWaiter){this.idWaiter=idWaiter;}
    public void setName(String name){this.name=name;}
    public void setLastName(String lastName){this.lastName=lastName;}
    //Functions
    @Override
    public String toString()
    {
        String s="Waiter{\n";
        s+="id: "+idWaiter+",\n";
        s+="name: \""+name+"\",\n";
        s+="last_name: \""+lastName+"\"\n";
        s+="}";
        return s;
    }
}

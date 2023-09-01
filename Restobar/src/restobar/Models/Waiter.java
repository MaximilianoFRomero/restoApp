package restobar.Models;

public class Waiter
{
    private int id;
    private String name;
    private String lastName;
    //Constructors
    public Waiter(int id,String name,String lastName)
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
    public String toString()
    {
        String s="Waiter{\n";
        s+="id: "+id+",\n";
        s+="name: \""+name+"\",\n";
        s+="last_name: \""+lastName+"\"\n";
        s+="}";
        return s;
    }
}

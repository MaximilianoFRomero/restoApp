package restobar.Models;

public class Category
{
    private int id;
    private String name;
    //Constructors
    public Category()
    {
        this.id=0;
        this.name="";
    }
    public Category(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public void setId(int idCategory){this.id=idCategory;}
    public void setName(String name){this.name=name;}
}

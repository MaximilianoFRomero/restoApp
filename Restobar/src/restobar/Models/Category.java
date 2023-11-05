package restobar.Models;

public class Category
{
    private long id;
    private String name;
    //Constructors
    public Category()
    {
        this.id=0;
        this.name="";
    }
    public Category(long id,String name)
    {
        this.id=id;
        this.name=name;
    }
    //Getters and setters
    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public void setId(long idCategory){this.id=idCategory;}
    public void setName(String name){this.name=name;}
}

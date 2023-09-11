package restobar.Models;

public class Category
{
    private int idCategory;
    private String name;
    //Constructors
    public Category()
    {
        this.idCategory=0;
        this.name="";
    }
    public Category(int idCategory,String name)
    {
        this.idCategory=idCategory;
        this.name=name;
    }
    //Getters and setters
    public int getIdCategory(){return this.idCategory;}
    public String getName(){return this.name;}
    public void setIdCategory(int idCategory){this.idCategory=idCategory;}
    public void setName(String name){this.name=name;}
}

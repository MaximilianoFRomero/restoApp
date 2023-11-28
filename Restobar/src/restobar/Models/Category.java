package restobar.Models;

/**
 * 
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Category
{
    /**
     * It represents the Category ID
     */
    private int id;
    /**
     * It represents the Category Name
     */
    private String name;
    //Constructors
    /**
     * It create an instance of class Category
     */
    public Category()
    {
        this.id=0;
        this.name="";
    }
    /**
     * 
     * @param id It represents the Category ID
     * @param name It represents the Category Name
     */
    public Category(int id,String name)
    {
        
        this.id=id;
        this.name=name;
    }
    //Getters and setters
    /**
     * Gets Category Id
     * @return category id 
     */
    public int getId(){return this.id;}
    /**
     * Gets Category Name
     * @return Category Name 
     */
    public String getName(){return this.name;}
    /**
     * Sets Category Id
     * @param idCategory 
     */
    public void setId(int idCategory){this.id=idCategory;}
    /**
     * Sets Category Name
     * @param name 
     */
    public void setName(String name){this.name=name;}
}

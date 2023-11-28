package restobar.Models;

/**
 *
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Waiter
{
    private int id;
    private String name;
    private String lastName;
    //Constructors

    /**
     *It creates an instance of class Waiter
     */
    public Waiter()
    {
        this.id=1;
        this.name="";
        this.lastName="";
    }

    /**
     *
     * @param idWaiter it represents a waiter id
     * @param name it represents a waiter name
     * @param lastName it represents a waiter last name
     */
    public Waiter(int idWaiter,String name,String lastName)
    {
        this.id=id;
        this.name=name;
        this.lastName=lastName;
    }
    //Getters and setters

    /**
     *Gets waiter id
     * @return id
     */
    public int getId(){return this.id;}

    /**
     *Gets waiter name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     *Gets waiter last name
     * @return lastName
     */
    public String getLastName(){return this.lastName;}

    /**
     *Sets waiter id
     * @param idWaiter
     */
    public void setId(int idWaiter){this.id=idWaiter;}

    /**
     *Sets waiter name
     * @param name
     */
    public void setName(String name){this.name=name;}

    /**
     *Sets waiter last name
     * @param lastName
     */
    public void setLastName(String lastName){this.lastName=lastName;}
    @Override
    public String toString()
    {
        return this.name+" "+this.lastName;
    }
}

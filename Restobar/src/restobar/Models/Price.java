package restobar.Models;

/**
 *
 * @author Romero Maximiliano Federico | Suizer Luca Daniel
 */
public class Price
{
    /**
     * It represents price value
     */
    private float value;
    //Constructors
    /**
     * It create an instance of class Price
     * @param value It represents price value
     */
    public Price(float value)
    {
        this.value=value;
    }
    //Getters and setters
    /**
     * Gets price value
     * @return 
     */
    public float getValue(){return this.value;}
    /**
     * Sets price value
     * @param value 
     */
    public void setValue(float value){this.value=value;}
}

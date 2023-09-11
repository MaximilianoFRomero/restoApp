/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restobar.Models;

/**
 *
 * @author lsd
 */
public class Price
{
    private float value;
    //Constructors
    public Price(float value)
    {
        this.value=value;
    }
    //Getters and setters
    public float getValue(){return this.value;}
    public void setValue(float value){this.value=value;}
}

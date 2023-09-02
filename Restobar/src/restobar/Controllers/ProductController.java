package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Product;

public class ProductController
{
    private List<Product> products;
    public ProductController()
    {
        this.products=new ArrayList();
    }
    //Funcitons
    public void addProduct(String name,String description,int value,Boolean elaborated,int category)
    {
        this.products.add(new Product(name,description,value,elaborated,category));
    }
    public void removeProduct(int index)
    {
        this.products.remove(index);
    }
    public Product getProduct(int index)
    {
        return this.products.get(index);
    }
}

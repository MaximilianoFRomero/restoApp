package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Category;
import restobar.Models.Product;

public class ProductController
{
    private List<Product> products;
    private CategoryController categoryCont;
    public ProductController()
    {
        this.products=new ArrayList();
        this.categoryCont=new CategoryController();
    }
    //Getters and setters
    public CategoryController getCategoryController(){return this.categoryCont;}
    //Funcitons
    public void addProduct(int idProduct,String name,String description,float price,Boolean elaborated,Category category)
    {
        this.products.add(new Product(idProduct,name,description,price,elaborated,category));
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

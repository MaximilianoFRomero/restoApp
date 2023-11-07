package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperProduct;
import restobar.Models.Category;
import restobar.Models.Price;
import restobar.Models.Product;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOProductSQL;

public class ProductController
{
    private DAOProductSQL dao;
    private MapperProduct mapper;
    private CategoryController categoryCont;
    public ProductController()
    {
        this.dao=new DAOProductSQL();
        this.mapper=new MapperProduct();
        this.categoryCont=new CategoryController();
    }
    //Getters and setters
    public CategoryController getCategoryController(){return this.categoryCont;}
    //Funcitons
    public void addProduct(String name,String description,float price,int stock,int idCategory) throws DAOException
    {
        Product p=new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(new Price(price));
        p.setStock(stock);
        p.setCategory(categoryCont.getCategoryById(idCategory));
        this.dao.save(mapper.convertProductToDTOProduct(p));
    }
    public void removeProduct(int index)
    {
    }
    public Product getProductById(int id) throws DAOException
    {
        return this.mapper.convertDTOProductToProduct(dao.byId(id));
    }
    /*
    public List<Product> getProductByIdCategory(long idCategory)
    {
        return 
    }
    */
}

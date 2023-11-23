package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperProduct;
import restobar.Models.Category;
import restobar.Models.Price;
import restobar.Models.Product;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOProductSQL;

public class ControllerProduct
{
    private DAOProductSQL dao;
    private MapperProduct mapper;
    private ControllerCategory categoryCont;
    public ControllerProduct()
    {
        this.dao=new DAOProductSQL();
        this.mapper=new MapperProduct();
        this.categoryCont=new ControllerCategory();
    }
    //Getters and setters
    public ControllerCategory getCategoryController(){return this.categoryCont;}
    //Funcitons
    public void addProduct(String name,String description,float price,int idCategory) throws DAOException
    {
        Product p=new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(new Price(price));
        //p.setCategory(categoryCont.getCategoryById(idCategory));
        p.setCategory(new Category(idCategory,"NONE"));
        this.dao.save(mapper.convertObjToDto(p));
    }
    public void modifyProduct(int id,String name,String description,Price price,Category category) throws DAOException
    {
        Product p=new Product(id,name,description,price.getValue(),category);
        this.dao.update(mapper.convertObjToDto(p));
    }
    public void removeProductById(int id) throws DAOException
    {
        Product p=new Product();
        p.setId(id);
        this.dao.delete(mapper.convertObjToDto(p));
    }
    public Product getProductById(int id) throws DAOException
    {
        return this.mapper.convertDtoToObj(dao.byId(id));
    }
    public List<Product> listAll() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
    public List<Product> getProductsFomCategory(int idCategory) throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.findByIdCategory(idCategory));
    }
    public void changeCategoryToNone(List<Product> list) throws DAOException
    {
        for(int i=0;i<list.size();i++)
            list.get(i).setCategory(new Category(1,"NONE"));
        for(int i=0;i<list.size();i++)
            dao.update(mapper.convertObjToDto(list.get(i)));
    }
}

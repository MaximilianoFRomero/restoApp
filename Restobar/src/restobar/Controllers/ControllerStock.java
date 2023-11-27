package restobar.Controllers;

import java.util.List;
import restobar.Mappers.MapperStock;
import restobar.Models.Product;
import restobar.Models.Stock;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOStockSQL;

public class ControllerStock
{
    private DAOStockSQL dao;
    private MapperStock mapper;
    private ControllerProduct productCont;
    //Constructors
    public ControllerStock()
    {
        this.dao=new DAOStockSQL();
        this.mapper=new MapperStock();
        this.productCont=null;
    }
    //Getters and setters
    public ControllerProduct getProductController(){return this.productCont;}
    public void setProductController(ControllerProduct cont){this.productCont=cont;}
    //Functions
    public void addStock(int idProduct,int total) throws DAOException
    {
        Stock o=new Stock();
        Product c=new Product();
        c.setId(idProduct);
        o.setProduct(c);
        o.setTotal(total);
        this.dao.save(mapper.convertObjToDto(o));
    }
    public void removeStockByIdProduct(int idProduct) throws DAOException
    {
        Stock o=new Stock();
        Product c=new Product();
        c.setId(idProduct);
        o.setProduct(c);
        this.dao.delete(mapper.convertObjToDto(o));
    }
    public Stock getStockByIdProduct(int idProduct) throws DAOException
    {
        Stock result=this.mapper.convertDtoToObj(dao.getStockFromIdProduct(idProduct));
        result.setProduct(this.productCont.getProductById(idProduct));
        return result;
    }
    public List<Stock> listAll() throws DAOException
    {
        List<Stock> results=this.mapper.convertListDtoToListObj(dao.listAll());
        for(int i=0;i<results.size();i++)
        {
            results.get(i).setProduct(this.productCont.getProductById(results.get(i).getProduct().getId()));
        }
        return results;
    }
}

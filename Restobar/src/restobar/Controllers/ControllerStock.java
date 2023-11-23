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
    //Constructors
    public ControllerStock()
    {
        this.dao=new DAOStockSQL();
        this.mapper=new MapperStock();
    }
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
    public void removeStock(int index)
    {}
    public Stock getStockById(int id)
    {
        return new Stock();
    }
    public List<Stock> listAll() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
    
}

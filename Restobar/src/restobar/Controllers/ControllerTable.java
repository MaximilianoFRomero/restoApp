package restobar.Controllers;

import java.util.List;
import restobar.Mappers.MapperTable;
import restobar.Models.Order;
import restobar.Models.Table;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOTableSQL;

public class ControllerTable
{
    private DAOTableSQL dao;
    private MapperTable mapper;
    private ControllerOrder orderCont;
    //Constructors
    public ControllerTable()
    {
        this.dao=new DAOTableSQL();
        this.mapper=new MapperTable();
        this.orderCont=new ControllerOrder();
    }
    //Getters and setters
    public ControllerOrder getOrderController(){return this.orderCont;}
    //Functions
    public void addTable(String name) throws DAOException
    {
        Table ta=new Table();
        ta.setName(name);
        ta.setOrder(new Order());
        dao.save(mapper.convertObjToDto(ta));
    }
    public void modifyTable(int id,String name,Order order) throws DAOException
    {
        Table t=new Table(id,name,order);
        this.dao.update(mapper.convertObjToDto(t));
    }
    public void removeTablebyId(int id) throws DAOException
    {
        Table t=new Table();
        t.setId(id);
        this.dao.delete(mapper.convertObjToDto(t));
    }
    public Table getTableById(int id) throws DAOException
    {
        Table result=this.mapper.convertDtoToObj(dao.byId(id));
        if(result.getOrder().getId()!=1)
            result.setOrder(orderCont.getOrderById(result.getOrder().getId()));
        else
        {
            orderCont.addOrder(id,0,0);
            List<Order>resultOrders=orderCont.listAllOrdersByIdTable(id);
            for(int i=0;i<resultOrders.size();i++)
            {
                if(resultOrders.get(i).getDateOpen().equals(resultOrders.get(i).getDateClose()))
                {
                    modifyTable(id,result.getName(),resultOrders.get(i));
                    result.setOrder(resultOrders.get(i));
                }
            }
        }
        return result;
    }
    public List<Table> listAll() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
}

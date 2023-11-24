package restobar.Controllers;

import java.util.Date;
import java.util.List;
import restobar.Mappers.MapperItem;
import restobar.Mappers.MapperOrder;
import restobar.Models.Item;
import restobar.Models.Order;
import restobar.Models.Waiter;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOItemSQL;
import restobar.Persistence.DAOOrderSQL;

public class ControllerOrder
{
    private DAOOrderSQL dao;
    private MapperOrder mapper;
    private DAOItemSQL daoItem;
    private MapperItem mapperItem;
    //Constructors
    public ControllerOrder()
    {
        this.dao=new DAOOrderSQL();
        this.mapper=new MapperOrder();
        this.daoItem=new DAOItemSQL();
        this.mapperItem=new MapperItem();
    }
    //Functions
    public void addOrder(int idTable,int idWaiter,int cutlery,Date dateOpen) throws DAOException
    {
        Order o=new Order();
        o.setIdTable(idTable);
        Waiter c=new Waiter();
        c.setId(idWaiter);
        o.setWaiter(c);
        o.setDateOpen(dateOpen);
        this.dao.save(mapper.convertObjToDto(o));
    }
    public void modifyOrder(int id,int idTable,Waiter waiter,int cutlery,Date dateOpen,Date dateClose) throws DAOException
    {
        Order o=new Order(id,idTable,waiter,cutlery,dateOpen,dateClose);
        this.dao.update(mapper.convertObjToDto(o));
    }
    public void removeOrderById(int id) throws DAOException
    {
        Order o=new Order();
        o.setId(id);
        this.dao.delete(mapper.convertObjToDto(o));
    }
    public Order getOrderById(int id) throws DAOException
    {
        Order o=mapper.convertDtoToObj(dao.byId(id));
        o.addItems(mapperItem.convertListDtoToListObj(daoItem.findByIdOrder(id)));
        return o;
    }
    public List<Order> listAllOrders() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
    public void addItemToOrder(Item item,Order order) throws DAOException
    {
        item.setIdOrder(order.getId());
        this.daoItem.save(mapperItem.convertObjToDto(item));
    }
}

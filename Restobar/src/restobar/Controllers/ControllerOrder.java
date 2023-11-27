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
    public void addOrder(int idTable,int idWaiter,int cutlery) throws DAOException
    {
        Order o=new Order();
        o.setIdTable(idTable);
        Waiter c=new Waiter();
        c.setId(idWaiter);
        o.setWaiter(c);
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
    public List<Order> listAllOrdersByIdTable(int idTable) throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.findByIdTable(idTable));
    }
    public void addItemToOrder(Item item,Order order) throws DAOException
    {
        item.setIdOrder(order.getId());
        boolean founded=false;
        int i=0;
        while(i<order.getItems().size() && !founded)
        {
            if(item.getProduct().getId()==order.getItem(i).getProduct().getId())
            {
                founded=true;
            }
            i++;
        }        
        if(!founded)
            this.daoItem.save(mapperItem.convertObjToDto(item));
        else
            throw new DAOException("Item already added to order.");
    }
    public void modifyItemFromOrder(int idProduct,int totalProduct,float individualPrice,Order order) throws DAOException
    {
        Item item=new Item();
        item.getProduct().setId(idProduct);
        item.getProduct().getPrice().setValue(individualPrice);
        item.setTotalProduct(totalProduct);
        item.setIdOrder(order.getId());
        this.daoItem.update(mapperItem.convertObjToDto(item));
    }
    public void changeTotalProductFromItem(int modification,Item item) throws DAOException
    {
        item.setTotalProduct(item.getTotalProduct()+modification);
        if(item.getTotalProduct()>0)
            this.daoItem.update(mapperItem.convertObjToDto(item));
        else
            this.daoItem.delete(mapperItem.convertObjToDto(item));
    }
}

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
    private ControllerWaiter waiterCont;
    private ControllerProduct productCont;
    //Constructors
    public ControllerOrder()
    {
        this.dao=new DAOOrderSQL();
        this.mapper=new MapperOrder();
        this.daoItem=new DAOItemSQL();
        this.mapperItem=new MapperItem();
        this.waiterCont=null;
        this.productCont=null;
    }
    //Getters and setters
    public ControllerWaiter getControllerWaiter(){return this.waiterCont;}
    public ControllerProduct getControllerProduct(){return this.productCont;}
    public void setControllerWaiter(ControllerWaiter c){this.waiterCont=c;}
    public void setControllerProduct(ControllerProduct c){this.productCont=c;}
    //Functions
    //Basics
    public void addOrder(int idTable,int idWaiter,int cutlery) throws DAOException
    {
        Order o=new Order();
        o.setIdTable(idTable);
        //o.setWaiter(waiterCont.getWaiterById(idWaiter));
        this.dao.save(mapper.convertObjToDto(o));
    }
    public void modifyOrder(int id,int idTable,int idWaiter,int cutlery,Date dateOpen,Date dateClose) throws DAOException
    {
        Order o=new Order(id,idTable,waiterCont.getWaiterById(idWaiter),cutlery,dateOpen,dateClose);
        this.dao.update(mapper.convertObjToDto(o));
    }
    public void modifyOrder(Order o) throws DAOException
    {
        this.dao.update(mapper.convertObjToDto(o));
    }
    public void removeOrderById(int id) throws DAOException
    {
        Order o=new Order();
        o.setId(id);
        this.dao.delete(mapper.convertObjToDto(o));
        this.daoItem.deleteByIdOrder(id);
    }
    public Order getOrderById(int id) throws DAOException
    {
        Order o=mapper.convertDtoToObj(dao.byId(id));
        o.setWaiter(waiterCont.getWaiterById(o.getWaiter().getId()));
        o.addItems(mapperItem.convertListDtoToListObj(daoItem.findByIdOrder(id)));
        return o;
    }
    public List<Order> listAllOrders() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
    public void changeTotalProductFromItem(int modification,Item item) throws DAOException
    {
        item.setTotalProduct(item.getTotalProduct()+modification);
        if(item.getTotalProduct()>0)
            this.daoItem.update(mapperItem.convertObjToDto(item));
        else
            this.daoItem.delete(mapperItem.convertObjToDto(item));
    }
    //Manage items from an order
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
        {
            this.daoItem.save(mapperItem.convertObjToDto(item));
            order.addItem(item);
        }else
            throw new DAOException("Item already added to order.");
    }
    public void addItemToOrder(int idProduct,int totalProduct,Order order) throws DAOException
    {
        Item item=new Item(productCont.getProductById(idProduct),order.getId(),totalProduct);
        boolean founded=false;
        int i=0;
        while(i<order.getItems().size() && !founded)
        {
            if(item.getProduct().getId()==order.getItem(i).getProduct().getId())
                founded=true;
            i++;
        }        
        if(!founded)
            this.daoItem.save(mapperItem.convertObjToDto(item));
        else
            throw new DAOException("Item already added to order.");
    }
    public void modifyItemFromOrder(int idProduct,int totalProduct,float individualPrice,Order order) throws DAOException
    {
        Item item=new Item(productCont.getProductById(idProduct),order.getId(),totalProduct);
        this.daoItem.update(mapperItem.convertObjToDto(item));
    }
    //Found orders by something
    public List<Order> listAllOrdersByIdWaiter(int idWaiter) throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.findByIdWaiter(idWaiter));
    }
    public List<Order> listAllClosedOrdersByIdTable(int idTable) throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.findClosedOrdersByIdTable(idTable));
    }
    public Order foundActiveOrderByIdTable(int idTable) throws DAOException
    {
        Order result=null;
        List<Order> tableOrders=this.mapper.convertListDtoToListObj(dao.findByIdTable(idTable));
        int i=0;
        boolean founded=false;
        while(!founded)
        {
            if(tableOrders.get(i).getDateClose()==null)
            {
                founded=true;
                result=tableOrders.get(i);
            }else
                i++;
        }
        return result;
    }
    //Control
    public void changeWaiterToNone(List<Order> list) throws DAOException
    {
        for(int i=0;i<list.size();i++)
        {
            list.get(i).getWaiter().setId(1);
            dao.update(mapper.convertObjToDto(list.get(i)));
        }
    }
    public void removeItemsByIdProduct(int idProduct) throws DAOException
    {
        this.daoItem.deleteByIdProduct(idProduct);
    }
    public void changeIdTableToNoneByIdTable(int idTable) throws DAOException
    {
        this.dao.changeByIdTableToNone(idTable);
    }
}

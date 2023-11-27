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
        this.orderCont=null;
    }
    //Getters and setters
    public ControllerOrder getControllerOrder(){return this.orderCont;}
    public void setControllerOrder(ControllerOrder c){this.orderCont=c;}
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
            orderCont.addOrder(id,1,0);
            result.setOrder(orderCont.foundActiveOrderByIdTable(id));
            this.dao.update(mapper.convertObjToDto(result));
        }
        return result;
    }
    public List<Table> listAll() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
    public void endOrderByIdTable(int id) throws DAOException
    {
        Table tableSelected=getTableById(id);
        this.orderCont.modifyOrder(tableSelected.endCurrentOrder());
        this.dao.endOrderById(id);
    }
}

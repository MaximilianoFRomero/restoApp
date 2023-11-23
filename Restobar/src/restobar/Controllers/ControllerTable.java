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
    //Constructors
    public ControllerTable()
    {
        this.dao=new DAOTableSQL();
        this.mapper=new MapperTable();
    } 
    //Functions
    public void addTable(String name) throws DAOException
    {
        Table ta=new Table();
        ta.setName(name);
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
    public Table getTableById(int id)
    {
        return new Table();
    }
    public List<Table> listAll() throws DAOException
    {
        return this.mapper.convertListDtoToListObj(dao.listAll());
    }
}

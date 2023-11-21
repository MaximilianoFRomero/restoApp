package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperWaiter;
import restobar.Models.Waiter;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOWaiterSQL;

public class WaiterController
{
    DAOWaiterSQL dao;
    MapperWaiter mapper;
    //Constructors
    public WaiterController()
    {
        this.dao=new DAOWaiterSQL();
        this.mapper=new MapperWaiter();
    }
    //Functions
    public void addWaiter(int id,String name,String lastName) throws DAOException
    {
        Waiter w=new Waiter();
        w.setId(id);
        w.setName(name);
        w.setLastName(lastName);
        this.dao.save(mapper.convertObjToDto(w));
    }
    public void removeWaiter(int index)
    {
    }
    public Waiter getWaiterById(int id) throws DAOException
    {
        return mapper.convertDtoToObj(dao.byId(id));
    }
    public List<Waiter> listAll() throws DAOException
    {
        return mapper.convertListDtoToListObj(dao.listAll());
    }
}

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
    public void addWaiter(long id,String name,String lastName) throws DAOException
    {
        Waiter w=new Waiter();
        w.setId(id);
        w.setName(name);
        w.setLastName(lastName);
        this.dao.save(mapper.convertWaiterToDTOWaiter(w));
    }
    public void removeWaiter(int index)
    {
    }
    public Waiter getWaiterById(long id) throws DAOException
    {
        return mapper.convertDTOWaiterToWaiter(dao.byId(id));
    }
    public List<Waiter> listAll() throws DAOException
    {
        return mapper.convertDTOWaitersToWaiters(dao.listAll());
    }
}

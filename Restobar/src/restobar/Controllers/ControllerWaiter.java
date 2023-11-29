package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperWaiter;
import restobar.Models.Waiter;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOWaiterSQL;

public class ControllerWaiter
{
    DAOWaiterSQL dao;
    MapperWaiter mapper;
    //Constructors
    public ControllerWaiter()
    {
        this.dao=new DAOWaiterSQL();
        this.mapper=new MapperWaiter();
    }
    //Functions
    public void addWaiter(String name,String lastName) throws DAOException
    {
        Waiter w=new Waiter();
        w.setName(name);
        w.setLastName(lastName);
        this.dao.save(mapper.convertObjToDto(w));
    }
    public void modifyWaiter(int id,String name,String lastName) throws DAOException
    {
        if(id!=1)
        {
            Waiter w=new Waiter(id,name,lastName);
            this.dao.update(mapper.convertObjToDto(w));
        }else
            throw new DAOException("Not possible modify this waiter.");
    }
    public void modifyWaiter(Waiter w) throws DAOException
    {
        if(w.getId()!=1)
        {
            this.dao.update(mapper.convertObjToDto(w));
        }else
            throw new DAOException("Not possible modify this waiter.");
    }
    public void removeWaiterById(int id) throws DAOException
    {
        if(id!=1)
        {
            Waiter w=new Waiter();
            w.setId(id);
            this.dao.delete(mapper.convertObjToDto(w));
        }else
            throw new DAOException("Not possible remove this waiter.");
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

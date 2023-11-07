package restobar.Persistence;

import java.util.List;

public interface DAOInterface<T>
{
    public void save(T t) throws DAOException;
    public void update(T t) throws DAOException;
    public void delete(T t) throws DAOException;
    public T byId(int id) throws DAOException;
    public List<T> listAll() throws DAOException;
    
}

package restobar.Persistence;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import restobar.DTOs.DTOWaiter;

public class DAOWaiterSQL implements DAOInterface<DTOWaiter>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOWaiter t) throws DAOException
    {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO waiters(name,lastName) VALUES(?,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,t.getName());
            stmt.setString(2,t.getLastName());
            stmt.executeUpdate();
            res=stmt.getGeneratedKeys();
            if(res.next())
                t.setId(res.getInt(1));
        }catch(SQLException ex)
        {
            throw new DAOException(ex.getMessage());
        }finally
        {
            if(res != null)
            {
                try
                {
                    res.close();
                    res = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
            if(stmt != null)
            {
                try
                {
                    stmt.close();
                    stmt = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void update(DTOWaiter t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(DTOWaiter t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DTOWaiter byId(long id) throws DAOException
    {
        String sql = "SELECT wa.id, wa.name, wa.lastName "
                + "FROM waiters wa WHERE wa.id="+id;
        DTOWaiter output = new DTOWaiter();
        
        Connection cn = null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            cn = connect();
            stmt = cn.createStatement();
            res = stmt.executeQuery(sql);
            output.setId(res.getLong(1));
            output.setName(res.getString(2));
            output.setLastName(res.getString(3));
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            if (res != null) {
                try {
                    res.close();
                    res = null;
                } catch (SQLException ex) {
                    throw new DAOException(ex.getMessage());
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException ex) {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
        return output;
    }

    @Override
    public List<DTOWaiter> listAll() throws DAOException
    {
        String sql = "SELECT wa.id, wa.name, wa.lastName "
                + "FROM waiters wa;";
        List<DTOWaiter> output = new ArrayList();
        
        Connection cn = null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            cn = connect();
            stmt = cn.createStatement();
            res = stmt.executeQuery(sql);
            convertToList(res, output);
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            if (res != null) {
                try {
                    res.close();
                    res = null;
                } catch (SQLException ex) {
                    throw new DAOException(ex.getMessage());
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException ex) {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
        return output;
    }
    private void convertToList(ResultSet res, List<DTOWaiter> output) throws SQLException
    {
        while (res.next()) {
            DTOWaiter wa = new DTOWaiter();
            wa.setId(res.getLong(1));
            wa.setName(res.getString(2));
            wa.setLastName(res.getString(3));
            output.add(wa);
        }
    }
}

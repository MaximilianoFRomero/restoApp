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
    public void save(DTOWaiter t) throws DAOException{
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
            if(con != null)
            {
                try
                {
                    con.close();
                    con = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void update(DTOWaiter t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE waiters SET name=?, lastName=? WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setString(1,t.getName());
            stmt.setString(2,t.getLastName());
            stmt.setInt(3,t.getId());
            stmt.executeUpdate();
        }catch(SQLException ex)
        {
            throw new DAOException(ex.getMessage());
        }finally
        {
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
            if(con != null)
            {
                try
                {
                    con.close();
                    con = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void delete(DTOWaiter t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM waiters WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getId());
            stmt.executeUpdate();
        }catch(SQLException ex)
        {
            throw new DAOException(ex.getMessage());
        }finally
        {
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
            if(con != null)
            {
                try
                {
                    con.close();
                    con = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public DTOWaiter byId(int id) throws DAOException{
        String sql = "SELECT id, name, lastName "
                + "FROM waiters WHERE id="+id+";";
        DTOWaiter output = null;
        
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            con = connect();
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            if(res.next())
                output=createDTO(res);
            else
                throw new DAOException("Waiter not founded.");
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
            
            if(con != null)
            {
                try
                {
                    con.close();
                    con = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
        return output;
    }

    @Override
    public List<DTOWaiter> listAll() throws DAOException{
        String sql = "SELECT id, name, lastName "
                + "FROM waiters;";
        List<DTOWaiter> output = new ArrayList();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            con = connect();
            stmt = con.createStatement();
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
            if(con != null)
            {
                try
                {
                    con.close();
                    con = null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
        return output;
    }
    @Override
    public void convertToList(ResultSet res, List<DTOWaiter> output) throws SQLException{
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOWaiter createDTO(ResultSet res) throws SQLException {
        DTOWaiter dto = new DTOWaiter();
        dto.setId(res.getInt(1));
        dto.setName(res.getString(2));
        dto.setLastName(res.getString(3));
        return dto;
    }
}

package restobar.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOTable;

public class DAOTableSQL implements DAOInterface<DTOTable>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOTable t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO tables(name,idOrder) VALUES(?,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,t.getName());
            stmt.setInt(2,t.getIdOrder());
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
    public void update(DTOTable t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE tables SET name=?, idOrder=? WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setString(1,t.getName());
            stmt.setInt(2,t.getIdOrder());
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
        }
    }

    @Override
    public void delete(DTOTable t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM tables WHERE id=?;";
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
        }
    }

    @Override
    public DTOTable byId(int id) throws DAOException {
        String sql = "SELECT ta.id, ta.name, ta.idOrder "
                + "FROM tables ta WHERE id="+id+";";
        DTOTable output = null;
        
        Connection cn = null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            cn = connect();
            stmt = cn.createStatement();
            res = stmt.executeQuery(sql);
            if(res.next())
                output=createDTO(res);
            else
                throw new DAOException("Table not founded.");
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
    public List<DTOTable> listAll() throws DAOException {
        String sql = "SELECT ta.id, ta.name, ta.idOrder "
                + "FROM tables ta;";
        List<DTOTable> output = new ArrayList();
        
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

    @Override
    public void convertToList(ResultSet res, List<DTOTable> output) throws SQLException {
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOTable createDTO(ResultSet res) throws SQLException {
        DTOTable dto = new DTOTable();
        dto.setId(res.getInt(1));
        dto.setName(res.getString(2));
        dto.setIdOrder(res.getInt(3));
        return dto;
    }
    
}

package restobar.Persistence;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import restobar.DTOs.DTOCategory;

public class DAOCategorySQL implements DAOInterface<DTOCategory>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/titos?user=root&password=");
    }
    @Override
    public void save(DTOCategory t) throws DAOException
    {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO categories(name) VALUES(?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,t.getName());
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
    public void update(DTOCategory t) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(DTOCategory t) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DTOCategory byId(long id) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DTOCategory> listAll() throws DAOException
    {
        String sql = "SELECT ca.id, ca.name "
                + "FROM categories ca;";
        List<DTOCategory> output = new ArrayList();
        
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
    private void convertToList(ResultSet res, List<DTOCategory> output) throws SQLException
    {
        while (res.next()) {
            DTOCategory ca = new DTOCategory();
            ca.setId(res.getInt(1));
            ca.setName(res.getString(2));
            output.add(ca);
        }
    }
}

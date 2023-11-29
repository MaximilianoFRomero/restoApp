package restobar.Persistence;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import restobar.DTOs.DTOCategory;

public class DAOCategorySQL implements DAOInterface<DTOCategory>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
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
    public void update(DTOCategory t) throws DAOException
    {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE categories SET name=? WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setString(1,t.getName());
            stmt.setInt(2,t.getId());
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
    public void delete(DTOCategory t) throws DAOException{
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM categories WHERE id=?;";
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
    public DTOCategory byId(int id) throws DAOException
    {
        String sql = "SELECT id, name "
                + "FROM categories WHERE id="+id+";";
        DTOCategory output=null;
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            con = connect();
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            if(res.next())
                output=createDTO(res);
            else
                throw new DAOException("Category not founded.");
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
                try {
                    con.close();
                    con=null;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOCategorySQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return output;
    }

    @Override
    public List<DTOCategory> listAll() throws DAOException
    {
        String sql = "SELECT id, name "
                + "FROM categories;";
        List<DTOCategory> output = new ArrayList();
        
        Connection con=null;
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
                try {
                    con.close();
                    con=null;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOCategorySQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return output;
    }
    @Override
    public void convertToList(ResultSet res, List<DTOCategory> output) throws SQLException
    {
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOCategory createDTO(ResultSet res) throws SQLException{
        DTOCategory dto = new DTOCategory();
        dto.setId(res.getInt(1));
        dto.setName(res.getString(2));
        return dto;
    }
}

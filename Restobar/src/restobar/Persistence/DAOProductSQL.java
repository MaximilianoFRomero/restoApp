package restobar.Persistence;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import restobar.DTOs.DTOProduct;

public class DAOProductSQL implements DAOInterface<DTOProduct>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOProduct t) throws DAOException
    {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO products(name,description,price,idCategory) VALUES(?,?,?,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,t.getName());
            stmt.setString(2,t.getDescription());
            stmt.setFloat(3, t.getPrice());
            stmt.setInt(4,t.getIdCategory());
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
    public void update(DTOProduct t) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(DTOProduct t) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DTOProduct byId(long id) throws DAOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DTOProduct> listAll() throws DAOException
    {
        String sql = "SELECT pr.id, pr.name, pr.description, pr.price "
                + "FROM products pr;";
        List<DTOProduct> output = new ArrayList();
        
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
    public List<DTOProduct> findByIdCategory(int idCategory) throws DAOException
    {
        String sql = "SELECT pr.id, pr.name, pr.description, pr.price "
                + "FROM products pr WHERE pr.idCategory="+idCategory;
        List<DTOProduct> output = new ArrayList();
        
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
    private void convertToList(ResultSet res, List<DTOProduct> output) throws SQLException
    {
        while (res.next()) {
            DTOProduct pr = new DTOProduct();
            pr.setId(res.getInt(1));
            pr.setName(res.getString(2));
            pr.setDescription(res.getString(3));
            pr.setPrice(res.getFloat(4));
            output.add(pr);
        }
    }    
}

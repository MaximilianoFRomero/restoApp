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
    public void update(DTOProduct t) throws DAOException{
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE products SET name=?, description=?, price=?, idCategory=? WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setString(1,t.getName());
            stmt.setString(2,t.getDescription());
            stmt.setFloat(3,t.getPrice());
            stmt.setInt(4,t.getIdCategory());
            stmt.setInt(5,t.getId());
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
    public void delete(DTOProduct t) throws DAOException{
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM products WHERE id=?;";
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
    public DTOProduct byId(int id) throws DAOException{
        String sql = "SELECT id, name, description, price, idCategory "
                + "FROM products WHERE id="+id+";";
        DTOProduct output = null;
        
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
                throw new DAOException("Product not founded.");
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
    public List<DTOProduct> listAll() throws DAOException{
        String sql = "SELECT pr.id, pr.name, pr.description, pr.price, pr.idCategory "
                + "FROM products pr;";
        List<DTOProduct> output = new ArrayList();
        
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
    public List<DTOProduct> findByIdCategory(int idCategory) throws DAOException{
        String sql = "SELECT pr.id, pr.name, pr.description, pr.price, pr.idCategory "
                + "FROM products pr WHERE pr.idCategory="+idCategory+";";
        List<DTOProduct> output = new ArrayList();
        
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
    public void convertToList(ResultSet res, List<DTOProduct> output) throws SQLException{
        while (res.next()) {
            output.add(createDTO(res));
        }
    }    

    @Override
    public DTOProduct createDTO(ResultSet res) throws SQLException {
        DTOProduct dto = new DTOProduct();
        dto.setId(res.getInt(1));
        dto.setName(res.getString(2));
        dto.setDescription(res.getString(3));
        dto.setPrice(res.getFloat(4));
        dto.setIdCategory(res.getInt(5));
        return dto;
    }
}

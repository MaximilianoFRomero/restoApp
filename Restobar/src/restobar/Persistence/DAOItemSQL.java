package restobar.Persistence;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import restobar.DTOs.DTOItem;

public class DAOItemSQL implements DAOInterface<DTOItem>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOItem t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO items(idProduct,idOrder,totalProduct,price) VALUES(?,?,?,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,t.getIdProduct());
            stmt.setInt(2,t.getIdOrder());
            stmt.setInt(3,t.getTotalProduct());
            stmt.setFloat(4,t.getIndividualPrice());
            stmt.executeUpdate();
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
            }if(con != null)
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
    public void update(DTOItem t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE items SET idProduct=?, idOrder=?, totalProduct=?, price=? WHERE idOrder=? AND idProduct=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getIdProduct());
            stmt.setInt(2,t.getIdOrder());
            stmt.setInt(3,t.getTotalProduct());
            stmt.setFloat(4,t.getIndividualPrice());
            stmt.setInt(5,t.getIdOrder());
            stmt.setInt(6,t.getIdProduct());
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
            }if(con != null)
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
    public void delete(DTOItem t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM items WHERE idProduct=? AND idOrder=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getIdProduct());
            stmt.setInt(2,t.getIdOrder());
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
    public DTOItem byId(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DTOItem> listAll() throws DAOException {
        String sql = "SELECT it.idProduct, it.idOrder, it.totalProduct, it.price "
                + "FROM items it;";
        List<DTOItem> output = new ArrayList();
        
        Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        
        try {
            con=connect();
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
    public void convertToList(ResultSet res, List<DTOItem> output) throws SQLException{
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOItem createDTO(ResultSet res) throws SQLException {
        DTOItem dto = new DTOItem();
        dto.setIdProduct(res.getInt(1));
        dto.setIdOrder(res.getInt(2));
        dto.setTotalProduct(res.getInt(3));
        dto.setIndividualPrice(res.getFloat(4));
        return dto;
    }
    public List<DTOItem> findByIdOrder(int idOrder) throws DAOException
    {
        String sql = "SELECT idProduct, idOrder, totalProduct, price "
                + "FROM items WHERE idOrder="+idOrder+";";
        
        List<DTOItem> output=new ArrayList();
        
        Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        
        try {
            con=connect();
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
                    con=null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
        return output;
    }
    public void deleteByIdOrder(int idOrder) throws DAOException
    {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM items WHERE idOrder=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(2,idOrder);
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
                    con=null;
                }catch (SQLException ex)
                {
                    throw new DAOException(ex.getMessage());
                }
            }
        }
    }
}

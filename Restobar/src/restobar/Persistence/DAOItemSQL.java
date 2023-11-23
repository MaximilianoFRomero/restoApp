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
            stmt.setInt(1,t.getIdOrder());
            stmt.setInt(1,t.getTotalProduct());
            stmt.setFloat(1,t.getIndividualPrice());
            stmt.executeUpdate();
            res=stmt.getGeneratedKeys();
            /*
            if(res.next())
                t.setId(res.getInt(1));
            */
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
    public void update(DTOItem t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(DTOItem t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DTOItem byId(int id) throws DAOException {
        String sql = "SELECT it.idProduct, it.idOrder, it.totalProduct, it.price "
                + "FROM items it WHERE id="+id+";";
        DTOItem output = null;
        
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
                throw new DAOException("Item not founded.");
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
    public List<DTOItem> listAll() throws DAOException {
        String sql = "SELECT it.idProduct, it.idOrder, it.totalProduct, it.price "
                + "FROM items it;";
        List<DTOItem> output = new ArrayList();
        
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
    
}

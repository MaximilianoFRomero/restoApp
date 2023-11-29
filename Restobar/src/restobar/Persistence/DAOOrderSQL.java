package restobar.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOOrder;

public class DAOOrderSQL implements DAOInterface<DTOOrder>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOOrder t) throws DAOException {
        java.sql.Timestamp dateOpen=new java.sql.Timestamp(t.getDateOpen().getTime());
        
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO orders(idTable,idWaiter,cutlery,dateOpen,dateClose,totalPrice) VALUES(?,?,?,?,NULL,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,t.getIdTable());
            stmt.setInt(2,t.getIdWaiter());
            stmt.setInt(3,t.getCutlery());
            stmt.setTimestamp(4, dateOpen);
            stmt.setFloat(5,t.getTotalPrice());
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
    public void update(DTOOrder t) throws DAOException {
        java.sql.Timestamp dateOpen=new java.sql.Timestamp(t.getDateOpen().getTime());
        
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE orders SET idTable=?, idWaiter=?, cutlery=?, dateOpen=?, dateClose=?, totalPrice=? WHERE id=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getIdTable());
            stmt.setInt(2,t.getIdWaiter());
            stmt.setInt(3,t.getCutlery());
            stmt.setTimestamp(4, dateOpen);
            if(t.getDateClose()!=null)
            {
                java.sql.Timestamp dateClose=new java.sql.Timestamp(t.getDateClose().getTime());
                stmt.setTimestamp(5, dateClose);
            }else
                stmt.setTimestamp(5, null);
            stmt.setFloat(6,t.getTotalPrice());
            stmt.setInt(7,t.getId());
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
    public void delete(DTOOrder t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM orders WHERE id=?;";
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
    public DTOOrder byId(int id) throws DAOException {
        String sql = "SELECT id, idTable, idWaiter, cutlery, dateOpen, dateClose, totalPrice "
                + "FROM orders WHERE id="+id+";";
        DTOOrder output = null;
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
        try {
            con=connect();
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            if(res.next())
                output=createDTO(res);
            else
                throw new DAOException("Order not founded.");
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
    public List<DTOOrder> listAll() throws DAOException {
        String sql = "SELECT id, idTable, idWaiter, cutlery, dateOpen, dateClose, totalPrice "
                + "FROM orders;";
        List<DTOOrder> output = new ArrayList();
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
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
    public void convertToList(ResultSet res, List<DTOOrder> output) throws SQLException {
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOOrder createDTO(ResultSet res) throws SQLException {
        DTOOrder dto = new DTOOrder();
        dto.setId(res.getInt(1));
        dto.setIdTable(res.getInt(2));
        dto.setIdWaiter(res.getInt(3));
        dto.setCutlery(res.getInt(4));
        dto.setDateOpen(res.getDate(5));
        if(res.getDate(6)!=null)
            dto.setDateClose(res.getDate(6));
        else
            dto.setDateClose(null);
        dto.setTotalPrice(res.getFloat(7));
        return dto;
    }
    public List<DTOOrder> findByIdTable(int idTable) throws DAOException
    {
        String sql = "SELECT id, idTable, idWaiter, cutlery, dateOpen, dateClose, totalPrice "
                + "FROM orders WHERE idTable="+idTable+";";
        List<DTOOrder> output = new ArrayList();
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
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
    public List<DTOOrder> findByIdWaiter(int idWaiter) throws DAOException
    {
        String sql = "SELECT id, idTable, idWaiter, cutlery, dateOpen, dateClose, totalPrice "
                + "FROM orders WHERE idWaiter="+idWaiter+";";
        List<DTOOrder> output = new ArrayList();
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
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
    public void changeByIdTableToNone(int idTable) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE orders SET idTable=1 WHERE idTable="+idTable+";";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
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
    public List<DTOOrder> findClosedOrdersByIdTable(int idTable) throws DAOException
    {
        String sql = "SELECT id, idTable, idWaiter, cutlery, dateOpen, dateClose, totalPrice "
                + "FROM orders WHERE idTable="+idTable+" AND dateClose IS NOT NULL;";
        List<DTOOrder> output = new ArrayList();
        
        Connection con=null;
        Statement stmt = null;
        ResultSet res = null;
        
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
}

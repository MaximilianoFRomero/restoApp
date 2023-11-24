package restobar.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOStock;

public class DAOStockSQL implements DAOInterface<DTOStock>
{
    private Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp?user=root&password=");
    }
    @Override
    public void save(DTOStock t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        
        String sql="INSERT INTO stocks(idProduct,total) VALUES(?,?);";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,t.getIdProduct());
            stmt.setInt(2,t.getTotal());
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
    public void update(DTOStock t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="UPDATE stocks set total=? WHERE idProduct=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getTotal());
            stmt.setInt(2,t.getIdProduct());
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
    public void delete(DTOStock t) throws DAOException {
        Connection con=null;
        PreparedStatement stmt=null;
        
        String sql="DELETE FROM stocks WHERE idProduct=?;";
        try
        {
            con=connect();
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,t.getIdProduct());
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
    public DTOStock byId(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DTOStock> listAll() throws DAOException {
        String sql = "SELECT st.idProduct, st.total "
                + "FROM stocks st;";
        List<DTOStock> output = new ArrayList();
        
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
    public void convertToList(ResultSet res, List<DTOStock> output) throws SQLException {
        while (res.next()) {
            output.add(createDTO(res));
        }
    }

    @Override
    public DTOStock createDTO(ResultSet res) throws SQLException {
        DTOStock dto = new DTOStock();
        dto.setIdProduct(res.getInt(1));
        dto.setTotal(res.getInt(2));
        return dto;
    }
    public DTOStock getStockFromIdProduct(int idProduct) throws DAOException
    {
        String sql = "SELECT st.idProduct, st.total "
                + "FROM stocks st WHERE idProduct="+idProduct+";";
        DTOStock output = null;
        
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
               throw new DAOException("Stock not founded.");
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
}

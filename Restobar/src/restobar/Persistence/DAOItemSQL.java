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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DTOItem> listAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void convertToList(ResultSet res, List<DTOItem> ouput) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

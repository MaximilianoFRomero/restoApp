package restobar;

import java.util.logging.Level;
import java.util.logging.Logger;
import restobar.DTOs.DTOCategory;
import restobar.DTOs.DTOProduct;
import restobar.DTOs.DTOWaiter;
import restobar.Persistence.DAOCategorySQL;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOProductSQL;
import restobar.Persistence.DAOWaiterSQL;

public class Restobar
{
    public static void main(String[] args)
    {
        System.out.println("TODO BIEN :) en OPENJDK 17");
        DAOCategorySQL emCategory=new DAOCategorySQL();
        System.out.println("\nListar categorias de la base de datos:");
        try {
            for (DTOCategory o: emCategory.listAll()) {
                System.out.println(o);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAOWaiterSQL emWaiter=new DAOWaiterSQL();
        System.out.println("\nListar mozos de la base de datos:");
        try {
            for (DTOWaiter o: emWaiter.listAll()) {
                System.out.println(o);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAOProductSQL emProduct=new DAOProductSQL();
        System.out.println("\nListar productos de la base de datos:");
        try {
            for (DTOProduct o: emProduct.listAll()) {
                System.out.println(o);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

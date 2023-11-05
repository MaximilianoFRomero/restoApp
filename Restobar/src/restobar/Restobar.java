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
import restobar.Views.Menues;

public class Restobar
{
    public static void main(String[] args)
    {
        Menues init = new Menues();
        init.setVisible(true);
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
        /*
        DAOProductSQL emProduct=new DAOProductSQL();
        DTOProduct t=new DTOProduct();
        t.setName("Fanta");
        t.setDescription("500cc de azucar naranja bebe.");
        t.setPrice(400);
        t.setIdCategory(2);
        try {
            emProduct.save(t);
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nListar productos de la base de datos:");
        try {
            for (DTOProduct o: emProduct.findByIdCategory(2)) {
                System.out.println(o);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
}

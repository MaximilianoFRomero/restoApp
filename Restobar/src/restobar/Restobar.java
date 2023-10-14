package restobar;

import java.util.logging.Level;
import java.util.logging.Logger;
import restobar.DTOs.DTOWaiter;
import restobar.Persistence.DAOException;
import restobar.Persistence.DAOWaiterSQL;
import restobar.Views.Menues;

public class Restobar
{
    public static void main(String[] args)
    {
        Menues init = new Menues();
        init.setVisible(true);
        System.out.println("TODO BIEN :) en OPENJDK 17");
        DAOWaiterSQL em=new DAOWaiterSQL();
        DTOWaiter waiter=new DTOWaiter();
        waiter.setName("Maxi");
        waiter.setLastName("Romero");
        try {
            System.out.println("Antes de guardar "+waiter);
            em.save(waiter);
            System.out.println("Después de guardar "+waiter);
        } catch (DAOException ex) {
            Logger.getLogger(Restobar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

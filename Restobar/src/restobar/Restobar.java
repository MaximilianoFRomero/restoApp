package restobar;

import java.util.Date;
import java.util.List;
import restobar.Models.Order;
import restobar.Models.Product;
import restobar.Models.Table;
import restobar.Models.Waiter;

public class Restobar
{
    public static void main(String[] args)
    {
        System.out.println("HOLA :)");
        Product p=new Product("Pepino","Es un pepino",100,false,0);
        Product p2=new Product("Gaseosa","Es una gaseosa",25,true,1);
        Order o=new Order();
        o.setDateClose(new Date());
        o.addProduct(p);
        o.addProduct(p2);
        Waiter w=new Waiter(0,"Luca","Suizer");
        Table t=new Table(0,1);
        t.setOrder(o);
        t.setWaiter(w);
        System.out.println(t.toString());
    }
    
}
